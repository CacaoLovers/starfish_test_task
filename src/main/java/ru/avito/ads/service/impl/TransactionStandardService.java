package ru.avito.ads.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.avito.ads.exception.GlobalServiceException;
import ru.avito.ads.exception.ResourceNotFoundException;
import ru.avito.ads.exception.UnacceptableActionException;
import ru.avito.ads.model.*;
import ru.avito.ads.model.record.AdvertisementStatus;
import ru.avito.ads.repository.TransactionRepository;
import ru.avito.ads.service.AccountService;
import ru.avito.ads.service.AdvertisementService;
import ru.avito.ads.service.TransactionService;
import ru.avito.ads.util.mapper.TransactionMapper;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TransactionStandardService implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final AccountService accountService;
    private final AdvertisementService advertisementService;

    @Override
    @Transactional
    public TransactionResponse createEntity(TransactionRequest transactionRequest) throws ResourceNotFoundException{
        Account seller = accountService.getEntityById(transactionRequest.getSeller());
        Account buyer = accountService.getEntityById(transactionRequest.getBuyer());
        Advertisement advertisement = advertisementService.getEntityById(transactionRequest.getAdvertisement());

        if (!advertisement.getStatus().equals(AdvertisementStatus.ACTIVE)
                || !advertisement.getOwner().equals(seller)
                || seller.equals(buyer)) {
            throw new UnacceptableActionException();
        }

        Transaction transaction = Transaction.builder()
                .advertisement(advertisement)
                .seller(seller)
                .buyer(buyer)
                .build();

        advertisement.setStatus(AdvertisementStatus.CLOSE);

        advertisementService.updateAdvertisement(advertisement);

        return transactionMapper.toEntityResponse(transactionRepository.save(transaction));
    }

    @Override
    public List<TransactionResponse> getEntities() {
        return transactionMapper.toEntityListResponse(transactionRepository.findAll());
    }

    @Override
    public TransactionResponse getEntityResponseById(UUID uuid) {
        return transactionMapper.toEntityResponse(getEntityById(uuid));
    }

    @Override
    public Transaction getEntityById(UUID uuid) throws ResourceNotFoundException{
        return transactionRepository.findById(uuid).orElseThrow(
                () -> new ResourceNotFoundException(uuid.toString(), Transaction.class)
        );
    }

    @Override
    public void deleteEntity(UUID entityId) {
        Transaction transaction = getEntityById(entityId);
        transactionRepository.delete(transaction);
    }


    @Override
    public List<TransactionResponse> getTransactionByBuyer(UUID buyerId) {
        Account account = accountService.getEntityById(buyerId);
        return transactionMapper.toEntityListResponse(transactionRepository.findTransactionByBuyer(account));
    }

    @Override
    public List<TransactionResponse> getTransactionBySeller(UUID sellerId) {
        Account account = accountService.getEntityById(sellerId);
        return transactionMapper.toEntityListResponse(transactionRepository.findTransactionBySeller(account));
    }
}
