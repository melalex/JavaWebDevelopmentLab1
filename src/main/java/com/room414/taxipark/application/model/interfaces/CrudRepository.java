package com.room414.taxipark.application.model.interfaces;

import java.util.List;

/**
 * Created by melalex on 2/6/17.
 */
public interface CrudRepository<K, T> {
    void create(T entity);
    T find(K id);
    List<T> findAll();
    void update(K id, T entity);
    void delete(K id);
}
