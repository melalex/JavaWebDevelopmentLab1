package com.room414.taxipark.application.controller.implementation;

import com.room414.taxipark.application.controller.infrastucture.Query;
import com.room414.taxipark.application.controller.interfaces.QueryExecutor;
import com.room414.taxipark.application.model.entities.Car;
import com.room414.taxipark.application.model.entities.Park;
import com.room414.taxipark.application.model.interfaces.CarRepository;
import com.room414.taxipark.application.model.interfaces.ParkRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by melalex on 2/7/17.
 */
class SimpleQueryExecutor implements QueryExecutor {
    private CarRepository carRepository;
    private ParkRepository parkRepository;

    SimpleQueryExecutor(CarRepository carRepository, ParkRepository parkRepository) {
        this.carRepository = carRepository;
        this.parkRepository = parkRepository;
    }

    @Override
    public void createCar(Query query) {
        Car car = Car.carBuilder()
                .setCarClass(Car.CarClass.valueOf(query.getArgument("CLASS")))
                .setConsumption(Float.parseFloat(query.getArgument("CONSUMPTION")))
                .setCurrency(Float.parseFloat(query.getArgument("CURRENCY")))
                .setManufacturer(query.getArgument("MANUFACTURER"))
                .setModel(query.getArgument("MODEL"))
                .setParkId(Integer.parseInt(query.getArgument("PARK")))
                .setSpeed(Float.parseFloat(query.getArgument("SPEED")))
                .build();

        carRepository.create(car);
    }

    @Override
    public void createPark(Query query) {
        Park park = Park.parkBuilder()
                .setBuildingNumber(query.getArgument("NUMBER"))
                .setCity(query.getArgument("CITY"))
                .setCountry(query.getArgument("COUNTRY"))
                .setStreet(query.getArgument("STREET"))
                .setName(query.getArgument("NAME"))
                .build();

        parkRepository.create(park);
    }

    @Override
    public List<Car> findAllCars(Query query) {
        return carRepository.findAllCarsFromPark(Integer.parseInt(query.getArgument("PARK")));
    }

    @Override
    public List<Park> findAllParks(Query query) {
        return parkRepository.findAll();
    }

    @Override
    public Car findCar(Query query) {
        return carRepository.find(Integer.parseInt(query.getArgument("ID")));
    }

    @Override
    public Park findPark(Query query) {
        return parkRepository.find(Integer.parseInt(query.getArgument("ID")));
    }

    @Override
    public void updateCar(Query query) {
        Car.CarBuilder carBuilder = carRepository
                .find(Integer.parseInt(query.getArgument("ID")))
                .carCopyBuilder();


    }

    @Override
    public void updatePark(Query query) {

    }

    @Override
    public void deleteCar(Query query) {

    }

    @Override
    public void deletePark(Query query) {

    }

    @Override
    public BigDecimal carsCost(Query query) {
        return null;
    }

    @Override
    public List<Car> sortByConsumption(Query query) {
        return null;
    }

    @Override
    public List<Car> inSpeedDiapason(Query query) {
        return null;
    }
}
