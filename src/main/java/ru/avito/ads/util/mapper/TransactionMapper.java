package ru.avito.ads.util.mapper;

import org.mapstruct.Mapper;
import ru.avito.ads.model.Transaction;
import ru.avito.ads.model.TransactionRequest;
import ru.avito.ads.model.TransactionResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper{
    TransactionResponse toEntityResponse(Transaction entityResponse);
    List<TransactionResponse> toEntityListResponse(Iterable<Transaction> entities);

}
