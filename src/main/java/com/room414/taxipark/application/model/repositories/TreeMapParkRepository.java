package com.room414.taxipark.application.model.repositories;

import com.room414.taxipark.application.model.entities.Park;
import com.room414.taxipark.application.model.interfaces.ParkRepository;

/**
 * Repository of Park entities.
 *
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
public class TreeMapParkRepository extends TreeMapRepository<Integer, Park> implements ParkRepository {

}
