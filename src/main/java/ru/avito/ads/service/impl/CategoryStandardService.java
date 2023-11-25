package ru.avito.ads.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.avito.ads.exception.ResourceAlreadyExistException;
import ru.avito.ads.exception.ResourceNotFoundException;
import ru.avito.ads.model.Advertisement;
import ru.avito.ads.model.Category;
import ru.avito.ads.model.CategoryRequest;
import ru.avito.ads.model.CategoryResponse;
import ru.avito.ads.repository.CategoryRepository;
import ru.avito.ads.service.AdvertisementService;
import ru.avito.ads.service.CategoryService;
import ru.avito.ads.util.mapper.CategoryMapper;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryStandardService implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponse createEntity(CategoryRequest categoryRequest) throws ResourceAlreadyExistException {
        if (categoryRepository.findCategoryByName(categoryRequest.getName()).isPresent())
            throw new ResourceAlreadyExistException(categoryRequest.getName(), Category.class);

        Category category = categoryMapper.toEntity(categoryRequest);
        Category parentCategory = getEntityById(categoryRequest.getParentId());
        category.setParent(parentCategory);
        return categoryMapper.toEntityResponse(category);
    }

    @Override
    public List<CategoryResponse> getEntities() {
        return categoryMapper.toEntityListResponse(categoryRepository.findAll());
    }

    @Override
    public CategoryResponse getEntityResponseById(UUID uuid) {
        return categoryMapper.toEntityResponse(getEntityById(uuid));
    }

    @Override
    public Category getEntityById(UUID uuid) throws ResourceNotFoundException {
        return categoryRepository.findById(uuid).orElseThrow(
                () -> new ResourceNotFoundException(uuid.toString(), Category.class)
        );
    }

    @Override
    public void deleteEntity(UUID entityId) {
        Category category = getEntityById(entityId);
        categoryRepository.delete(category);
    }

    @Override
    @Transactional
    public CategoryResponse updateCategory(CategoryRequest categoryRequest, UUID categoryId) throws ResourceNotFoundException{
        if (categoryRepository.findCategoryByName(categoryRequest.getName()).isPresent())
            throw new ResourceAlreadyExistException(categoryRequest.getName(), Category.class);

        Category category = getEntityById(categoryId);
        Category parentCategory = getEntityById(categoryRequest.getParentId());
        category.setParent(parentCategory);
        category.setName(Objects.requireNonNullElse(categoryRequest.getName(), category.getName()));

        return categoryMapper.toEntityResponse(categoryRepository.save(category));
    }
}
