package com.room414.taxipark.application.controller.implementation;

import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.controller.interfaces.Controller;
import com.room414.taxipark.application.controller.interfaces.QueryAnalyzer;
import com.room414.taxipark.application.controller.interfaces.QueryExecutor;
import com.room414.taxipark.application.model.entities.Car;
import com.room414.taxipark.application.model.entities.Park;
import com.room414.taxipark.application.model.interfaces.CarRepository;
import com.room414.taxipark.application.model.interfaces.ParkRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by melalex on 2/5/17.
 */
public class SimpleController implements Controller {
    private QueryAnalyzer queryAnalyzer = new SimpleQueryAnalyzer();
    private QueryExecutor queryExecutor;

    public SimpleController(CarRepository carRepository, ParkRepository parkRepository) {
        queryExecutor = new SimpleQueryExecutor(carRepository, parkRepository);
    }

    @Override
    public void executeQuery(String request) {
        Query query = queryAnalyzer.analyze(request);

        switch (query.getQueryType()) {
            case CREATE_CAR:
                if (SimpleQueryValidator.validateCreateCar(query)) {
                    queryExecutor.createCar(query);
                } else {

                }
                break;
            case CREATE_PARK:
                if (SimpleQueryValidator.validateCreatePark(query)) {
                    queryExecutor.createPark(query);
                } else {

                }
                break;
            case FIND_ALL_CARS:
                if (SimpleQueryValidator.validateFindAllCars(query)) {
                    List<Car> allCars = queryExecutor.findAllCars(query);
                } else {

                }
                break;
            case FIND_ALL_PARKS:
                if (SimpleQueryValidator.validateFindAllParks(query)) {
                    List<Park> allParks = queryExecutor.findAllParks(query);
                } else {

                }
                break;
            case GET_CAR:
                if (SimpleQueryValidator.validateFindCar(query)) {
                    Car car = queryExecutor.findCar(query);
                } else {

                }
                break;
            case GET_PARK:
                if (SimpleQueryValidator.validateFindPark(query)) {
                    Park park = queryExecutor.findPark(query);

                } else {

                }
                break;
            case UPDATE_CAR:
                if (SimpleQueryValidator.validateUpdateCar(query)) {
                    queryExecutor.updateCar(query);
                } else {

                }
                break;
            case UPDATE_PARK:
                if (SimpleQueryValidator.validateUpdatePark(query)) {
                    queryExecutor.updatePark(query);
                } else {

                }
                break;
            case DELETE_CAR:
                if (SimpleQueryValidator.validateDeleteCar(query)) {
                    queryExecutor.deleteCar(query);
                } else {

                }
                break;
            case DELETE_PARK:
                if (SimpleQueryValidator.validateDeletePark(query)) {
                    queryExecutor.deletePark(query);

                } else {

                }
                break;
            case CARS_COST:
                if (SimpleQueryValidator.validateCarsCost(query)) {
                    BigDecimal carsCost = queryExecutor.carsCost(query);
                } else {

                }
                break;
            case CONSUMPTION:
                if (SimpleQueryValidator.validateSortByConsumption(query)) {
                    List<Car> sortedCars = queryExecutor.sortByConsumption(query);
                } else {

                }
                break;
            case SPEED:
                if (SimpleQueryValidator.validateInSpeedDiapason(query)) {
                    List<Car> carsInSpeedDiapason = queryExecutor.inSpeedDiapason(query);
                } else {

                }
                break;
            case INVALID:
                default:
        }
    }
}
