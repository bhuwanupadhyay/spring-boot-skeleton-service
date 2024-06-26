package com.bhuwanupadhyay.demos.model;

import java.util.Collection;
import java.util.Optional;

public interface IEntityRepository {

    default void create(EntityId entityId, EntityProperties properties) {
        createAndGet(entityId, properties);
    }

    @SuppressWarnings("UnusedReturnValue")
    Optional<EntityInfo> createAndGet(EntityId entityId, EntityProperties properties);

    @SuppressWarnings("UnusedReturnValue")
    Optional<EntityInfo> updateAndGet(EntityId entityId, EntityProperties properties);

    default void update(EntityId entityId, EntityProperties properties) {
        updateAndGet(entityId, properties);
    }

    void deleteById(EntityId entityId);

    Optional<EntityInfo> getById(EntityId entityId);

    Collection<EntityInfo> get(Query query);

    default Optional<EntityInfo> getFirst(Query query) {
        Collection<EntityInfo> collection = get(query);
        return !collection.isEmpty() ? collection.stream().findFirst() : Optional.empty();
    }

    PageResults<EntityInfo> search(SearchQuery query);
}
