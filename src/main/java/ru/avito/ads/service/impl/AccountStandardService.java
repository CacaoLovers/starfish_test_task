package ru.avito.ads.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.avito.ads.exception.ResourceNotFoundException;
import ru.avito.ads.model.Account;
import ru.avito.ads.model.AccountRequest;
import ru.avito.ads.model.AccountResponse;
import ru.avito.ads.repository.AccountRepository;
import ru.avito.ads.service.AccountService;
import ru.avito.ads.util.mapper.AccountMapper;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountStandardService implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public AccountResponse createEntity(AccountRequest accountRequest) {
        Account account = accountMapper.toEntity(accountRequest);
        return accountMapper.toEntityResponse(accountRepository.save(account));
    }

    @Override
    public List<AccountResponse> getEntities() {
        return accountMapper.toEntityListResponse(accountRepository.findAll());
    }

    @Override
    public AccountResponse getEntityResponseById(UUID uuid) {
        return accountMapper.toEntityResponse(getEntityById(uuid));
    }

    @Override
    public Account getEntityById(UUID uuid) throws ResourceNotFoundException{
        return accountRepository.findById(uuid).orElseThrow(
                () -> new ResourceNotFoundException(uuid.toString(), Account.class)
        );
    }

    @Override
    public void deleteEntity(UUID entityId) {
        Account account = getEntityById(entityId);
        accountRepository.delete(account);
    }
}
