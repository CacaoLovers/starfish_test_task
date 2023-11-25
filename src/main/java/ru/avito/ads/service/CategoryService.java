package ru.avito.ads.service;

import ru.avito.ads.model.Category;
import ru.avito.ads.model.CategoryRequest;
import ru.avito.ads.model.CategoryResponse;

import java.util.UUID;

public interface CategoryService extends AbstractCrudService<Category, UUID, CategoryRequest, CategoryResponse>{

    CategoryResponse updateCategory(CategoryRequest categoryRequest, UUID categoryId);

}
