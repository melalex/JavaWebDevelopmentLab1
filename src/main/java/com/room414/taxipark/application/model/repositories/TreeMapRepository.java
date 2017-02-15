package com.room414.taxipark.application.model.repositories;

import com.room414.taxipark.application.model.entities.Entity;
import com.room414.taxipark.application.model.interfaces.CrudRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Repository that provides default CRUD operation.
 *
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
public class TreeMapRepository<K, T extends Entity<K>> implements CrudRepository<K, T> {
    private int nextId = 0;

    protected Map<K, T> dataStore = new TreeMap<>();

    /**
     * Add new entity to repository
     *
     * @param entity entity that should be added.
     */
    @Override
    public void create(T entity) {
        if (dataStore.containsKey(entity.getId())) {
            throw new IllegalArgumentException("Repository already contains entity with id " + entity.getId());
        }

        entity.setId(getNextId());

        dataStore.put(entity.getId(), entity);
    }

    /**
     * Find entity by id.
     *
     * @param id id of entity
     * @return entity with id = param id
     */
    @Override
    public T find(K id) {
        return dataStore.get(id);
    }

    /**
     * @return All entities that stores in repository
     */
    @Override
    public List<T> findAll() {
        return new LinkedList<>(dataStore.values());
    }

    /**
     * Updates value of entity param
     *
     * @param entity entity to update
     */
    @Override
    public void update(T entity) {
        dataStore.put(entity.getId(), entity);
    }

    /**
     * Deletes entity with specific id.
     *
     * @param id id of entity to remove
     */
    @Override
    public void delete(K id) {
        dataStore.remove(id);
    }

    public int getNextId() {
        return nextId++;
    }
}
