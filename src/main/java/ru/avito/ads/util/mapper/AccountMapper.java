package ru.avito.ads.util.mapper;

import org.mapstruct.Mapper;
import ru.avito.ads.model.Account;
import ru.avito.ads.model.AccountRequest;
import ru.avito.ads.model.AccountResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper{
    Account toEntity(AccountRequest entityRequest);
    AccountResponse toEntityResponse(Account entityResponse);
    List<AccountResponse> toEntityListResponse(Iterable<Account> entities);

}
