package ru.avito.ads.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.avito.ads.model.Account;

import java.util.UUID;

@Repository
public interface AccountRepository extends CrudRepository<Account, UUID> {

}
