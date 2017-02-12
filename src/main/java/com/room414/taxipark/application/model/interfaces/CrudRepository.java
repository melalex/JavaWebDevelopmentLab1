package com.room414.taxipark.application.model.interfaces;

import java.util.List;

/**
 * Interface of repository that provides default CRUD operation.
 *
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
public interface CrudRepository<K, T> {
    /**
     * Add new entity to repository
     *
     * @param entity entity that should be added.
     */
    void create(T entity);

    /**
     * Find entity by id.
     *
     * @param id id of entity
     * @return entity with id = param id
     */
    T find(K id);

    /**
     * @return All entities that stores in repository
     */
    List<T> findAll();

    /**
     * Updates value of entity param
     *
     * @param entity entity to update
     */
    void update(T entity);

    /**
     * Deletes entity with specific id.
     *
     * @param id id of entity to remove
     */
    void delete(K id);
}
