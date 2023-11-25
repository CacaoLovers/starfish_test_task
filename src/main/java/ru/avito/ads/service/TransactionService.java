package ru.avito.ads.service;

import ru.avito.ads.model.Transaction;
import ru.avito.ads.model.TransactionRequest;
import ru.avito.ads.model.TransactionResponse;

import java.util.List;
import java.util.UUID;

public interface TransactionService extends AbstractCrudService<Transaction, UUID, TransactionRequest, TransactionResponse> {
    List<TransactionResponse> getTransactionByBuyer(UUID buyerId);
    List<TransactionResponse> getTransactionBySeller(UUID sellerId);
}
