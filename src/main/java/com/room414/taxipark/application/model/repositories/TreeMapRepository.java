package com.room414.taxipark.application.model.repositories;

import com.room414.taxipark.application.model.entities.Entity;
import com.room414.taxipark.application.model.interfaces.CrudRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by melalex on 2/6/17.
 */
public class TreeMapRepository<K, T extends Entity<K>> implements CrudRepository<K, T> {
    protected Map<K, T> dataStore = new TreeMap<>();

    @Override
    public void create(T entity) {
        dataStore.put(entity.getId(), entity);
    }

    @Override
    public T find(K id) {
        return dataStore.get(id);
    }

    @Override
    public List<T> findAll() {
        return new LinkedList<>(dataStore.values());
    }

    @Override
    public void update(K id, T entity) {
        dataStore.put(id, entity);
    }

    @Override
    public void delete(K id) {
        dataStore.remove(id);
    }
}
