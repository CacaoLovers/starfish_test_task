package ru.avito.ads.util.mapper;


import org.mapstruct.Mapper;
import ru.avito.ads.model.Category;
import ru.avito.ads.model.CategoryRequest;
import ru.avito.ads.model.CategoryResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper{
    Category toEntity(CategoryRequest entityRequest);
    CategoryResponse toEntityResponse(Category entityResponse);
    List<CategoryResponse> toEntityListResponse(Iterable<Category> entities);

}
