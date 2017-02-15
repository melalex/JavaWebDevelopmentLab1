package com.room414.taxipark.application.model.entities;

/**
 *
 * @version 1.0 2/6/17
 * @author melalex
 */
public interface Entity<K> {
    K getId();
    void setId(Integer id);
}
