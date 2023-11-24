package ru.avito.ads.util.mapper;

import org.mapstruct.Mapper;
import ru.avito.ads.model.Advertisement;
import ru.avito.ads.model.AdvertisementRequest;
import ru.avito.ads.model.AdvertisementResponse;

@Mapper(componentModel = "spring")
public interface AdvertisementMapper extends AbstractMapper<Advertisement, AdvertisementRequest, AdvertisementResponse>{
}
