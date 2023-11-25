package ru.avito.ads.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.avito.ads.api.TransactionApi;
import ru.avito.ads.model.AdvertisementResponse;
import ru.avito.ads.model.TransactionRequest;
import ru.avito.ads.model.TransactionResponse;
import ru.avito.ads.repository.TransactionRepository;
import ru.avito.ads.service.TransactionService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class TransactionController implements TransactionApi {

    private final TransactionService transactionService;

    @Override
    public ResponseEntity<TransactionResponse> createDeal(TransactionRequest body) {
        return ResponseEntity.ok().body(transactionService.createEntity(body));
    }

    @Override
    public ResponseEntity<List<TransactionResponse>> getTransactionByBuyer(UUID accountId) {
        return ResponseEntity.ok().body(transactionService.getTransactionByBuyer(accountId));
    }

    @Override
    public ResponseEntity<List<TransactionResponse>> getTransactionBySeller(UUID accountId) {
        return ResponseEntity.ok().body(transactionService.getTransactionBySeller(accountId));
    }
}
