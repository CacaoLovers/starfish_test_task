package ru.avito.ads.service;

import ru.avito.ads.model.Advertisement;
import ru.avito.ads.model.AdvertisementRequest;
import ru.avito.ads.model.AdvertisementResponse;
import ru.avito.ads.model.AdvertisementUpdateRequest;

import java.util.List;
import java.util.UUID;

public interface AdvertisementService extends AbstractCrudService<Advertisement, UUID, AdvertisementRequest, AdvertisementResponse> {
    AdvertisementResponse updateAdvertisement(AdvertisementUpdateRequest advertisementRequest, UUID advertisementId);
    List<AdvertisementResponse>  getAdvertisementByOwner(UUID ownerId);
    Advertisement updateAdvertisement(Advertisement advertisement);
}