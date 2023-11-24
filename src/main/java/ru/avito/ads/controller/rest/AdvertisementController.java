package ru.avito.ads.controller.rest;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.avito.ads.api.AdvertisementApi;
import ru.avito.ads.model.AdvertisementRequest;
import ru.avito.ads.model.AdvertisementResponse;
import ru.avito.ads.model.AdvertisementUpdateRequest;
import ru.avito.ads.service.AdvertisementService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class AdvertisementController implements AdvertisementApi {

    private final AdvertisementService advertisementService;


    @Override
    public ResponseEntity<AdvertisementResponse> createAdvertisement(AdvertisementRequest body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(advertisementService.createEntity(body));
    }

    @Override
    public ResponseEntity<Void> deleteAdvertisement(UUID advertisementId) {
        return AdvertisementApi.super.deleteAdvertisement(advertisementId);
    }

    @Override
    public ResponseEntity<List<AdvertisementResponse>> getAdvertisement() {
        return ResponseEntity.ok().body(advertisementService.getEntities());
    }

    @Override
    public ResponseEntity<AdvertisementResponse> getAdvertisementById(UUID advertisementId) {
        return ResponseEntity.ok().body(advertisementService.getEntityResponseById(advertisementId));
    }

    @Override
    public ResponseEntity<List<AdvertisementResponse>> getAdvertisementByOwner(UUID accountId) {
        return ResponseEntity.ok().body(advertisementService.getAdvertisementByOwner(accountId));
    }

    @Override
    public ResponseEntity<AdvertisementResponse> updateAdvertisement(UUID advertisementId, AdvertisementUpdateRequest body) {
        return ResponseEntity.ok().body(advertisementService.updateAdvertisement(body, advertisementId));
    }

}
