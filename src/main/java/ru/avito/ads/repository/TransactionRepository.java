package ru.avito.ads.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.avito.ads.model.Account;
import ru.avito.ads.model.Transaction;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, UUID> {
    List<Transaction> findTransactionByBuyer(Account buyer);
    List<Transaction> findTransactionBySeller(Account seller);
}
