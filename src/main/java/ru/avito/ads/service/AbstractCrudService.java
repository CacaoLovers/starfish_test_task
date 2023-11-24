package ru.avito.ads.service;

import java.util.List;

public interface AbstractCrudService<Entity, ID, EntityRequest, EntityResponse> {
    EntityResponse createEntity(EntityRequest entityRequest);
    List<EntityResponse> getEntities();
    EntityResponse getEntityResponseById(ID id);
    Entity getEntityById(ID id);
    void deleteEntity(ID entityId);
}
