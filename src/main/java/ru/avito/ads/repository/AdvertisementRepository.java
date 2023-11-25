package ru.avito.ads.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.avito.ads.model.Account;
import ru.avito.ads.model.Advertisement;

import java.util.List;
import java.util.UUID;

@Repository
public interface AdvertisementRepository extends CrudRepository<Advertisement, UUID> {
    List<Advertisement> findAdvertisementsByOwner(Account owner);
}
