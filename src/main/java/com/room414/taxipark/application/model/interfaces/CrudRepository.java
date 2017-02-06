package com.room414.taxipark.application.model.interfaces;

import java.util.List;

/**
 * Created by melalex on 2/6/17.
 */
public interface CrudRepository<T> {
    void create(T entity);
    T find(int id);
    List<T> findAll();
    void update(int id, T entity);
    void delete(int id);
}
