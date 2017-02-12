package com.room414.taxipark.application.model.interfaces;

import com.room414.taxipark.application.model.entities.Park;
import com.room414.taxipark.application.model.repositories.TreeMapParkRepository;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

/**
 * Repository of Park entities.
 *
 * @see Park
 * @version 1.0 12 Feb 2017
 * @author melalex
 */
@JsonDeserialize(as = TreeMapParkRepository.class)
public interface ParkRepository extends CrudRepository<Integer, Park> {

}
