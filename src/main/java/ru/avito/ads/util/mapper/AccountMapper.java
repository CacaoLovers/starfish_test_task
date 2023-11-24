package ru.avito.ads.util.mapper;

import org.mapstruct.Mapper;
import ru.avito.ads.model.Account;
import ru.avito.ads.model.AccountRequest;
import ru.avito.ads.model.AccountResponse;
@Mapper(componentModel = "spring")
public interface AccountMapper extends AbstractMapper<Account, AccountRequest, AccountResponse> {

}
