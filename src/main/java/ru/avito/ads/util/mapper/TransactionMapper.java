package ru.avito.ads.util.mapper;

import org.mapstruct.Mapper;
import ru.avito.ads.model.Transaction;
import ru.avito.ads.model.TransactionRequest;
import ru.avito.ads.model.TransactionResponse;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends AbstractMapper<Transaction, TransactionRequest, TransactionResponse>{
}
