package ru.avito.ads.util.mapper;


import org.mapstruct.Mapper;
import ru.avito.ads.model.Category;
import ru.avito.ads.model.CategoryRequest;
import ru.avito.ads.model.CategoryResponse;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends AbstractMapper<Category, CategoryRequest, CategoryResponse>{
}
