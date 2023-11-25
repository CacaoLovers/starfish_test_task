package ru.avito.ads.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.avito.ads.exception.ResourceNotFoundException;
import ru.avito.ads.model.*;
import ru.avito.ads.model.record.AdvertisementStatus;
import ru.avito.ads.repository.AdvertisementRepository;
import ru.avito.ads.service.AccountService;
import ru.avito.ads.service.AdvertisementService;
import ru.avito.ads.service.CategoryService;
import ru.avito.ads.util.mapper.AdvertisementMapper;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AdvertisementStandardService implements AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private final AdvertisementMapper advertisementMapper;
    private final AccountService accountService;
    private final CategoryService categoryService;

    @Override
    public AdvertisementResponse createEntity(AdvertisementRequest advertisementRequest) {
        Advertisement advertisement = advertisementMapper.toEntity(advertisementRequest);
        advertisement.setStatus(AdvertisementStatus.ACTIVE);
        return advertisementMapper.toEntityResponse(advertisementRepository.save(advertisement));
    }

    @Transactional
    @Override
    public AdvertisementResponse updateAdvertisement(AdvertisementUpdateRequest advertisementRequest, UUID advertisementId) throws ResourceNotFoundException{
        Advertisement advertisement = getEntityById(advertisementId);

        advertisement.setCategory(categoryService.getEntityById(advertisementRequest.getCategory()));
        advertisement.setTitle(Objects.requireNonNullElse(advertisementRequest.getTitle(), advertisement.getTitle()));
        advertisement.setDescription(Objects.requireNonNullElse(advertisementRequest.getDescription(), advertisement.getDescription()));

        if (advertisementRequest.getStatus() != null)
            advertisement.setStatus(AdvertisementStatus.valueOf(advertisementRequest.getStatus().toString()));

        return advertisementMapper.toEntityResponse(advertisementRepository.save(advertisement));
    }

    @Override
    public Advertisement updateAdvertisement(Advertisement advertisement) {
        return advertisementRepository.save(advertisement);
    }

    @Override
    public void deleteEntity(UUID advertisementId) {
        Advertisement advertisement = getEntityById(advertisementId);
        advertisementRepository.delete(advertisement);
    }

    @Override
    public AdvertisementResponse getEntityResponseById(UUID advertisementId) {
        return advertisementMapper.toEntityResponse(getEntityById(advertisementId));
    }

    @Override
    public Advertisement getEntityById(UUID advertisementId) throws ResourceNotFoundException{
        return advertisementRepository.findById(advertisementId).orElseThrow(
                () -> new ResourceNotFoundException(advertisementId.toString(), Advertisement.class)
        );
    }

    @Override
    public List<AdvertisementResponse> getAdvertisementByOwner(UUID ownerId) {
        Account account = accountService.getEntityById(ownerId);

        return advertisementMapper.toEntityListResponse(advertisementRepository.findAdvertisementsByOwner(account));
    }

    @Override
    public List<AdvertisementResponse> getEntities() {
        return advertisementMapper.toEntityListResponse(advertisementRepository.findAll());
    }
}
