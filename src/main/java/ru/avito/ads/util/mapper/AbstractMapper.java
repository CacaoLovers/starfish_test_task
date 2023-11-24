package ru.avito.ads.util.mapper;

import java.util.List;

public interface AbstractMapper<Entity, EntityRequest, EntityResponse> {
    Entity toEntity(EntityRequest entityRequest);
    EntityResponse toEntityResponse(Entity entityResponse);
    List<EntityResponse> toEntityListResponse(Iterable<Entity> entities);
}
