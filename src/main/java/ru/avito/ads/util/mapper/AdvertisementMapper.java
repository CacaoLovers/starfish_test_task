package ru.avito.ads.util.mapper;

import org.mapstruct.Mapper;
import ru.avito.ads.model.Advertisement;
import ru.avito.ads.model.AdvertisementRequest;
import ru.avito.ads.model.AdvertisementResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdvertisementMapper{

    Advertisement toEntity(AdvertisementRequest entityRequest);

    AdvertisementResponse toEntityResponse(Advertisement entityResponse);
    List<AdvertisementResponse> toEntityListResponse(Iterable<Advertisement> entities);

}
