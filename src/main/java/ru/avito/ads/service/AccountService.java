package ru.avito.ads.service;

import ru.avito.ads.model.Account;
import ru.avito.ads.model.AccountRequest;
import ru.avito.ads.model.AccountResponse;

import java.util.UUID;

public interface AccountService extends AbstractCrudService<Account, UUID, AccountRequest, AccountResponse> {

}
