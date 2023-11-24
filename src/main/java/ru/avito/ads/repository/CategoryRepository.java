package ru.avito.ads.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.avito.ads.model.Category;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends CrudRepository<Category, UUID> {
    Optional<Category> findCategoryByName(String name);
}
