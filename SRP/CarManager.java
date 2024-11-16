package com.directi.training.srp.exercise_refactored;

import java.util.List;

public class CarManager
{
    private final CarRepository _carRepository;
    private final CarFormatter _carFormatter;
    private final CarSelection _carSelection;

    public CarManager()
    {
        _carRepository = new CarRepository();
        _carFormatter = new CarFormatter();
        _carSelection = new CarSelection();
    }

    public Car getCarById(String carId)
    {
        return _carRepository.getFromDb(carId);
    }

    public String getAllCarNames()
    {
        List<Car> cars = _carRepository.getAllCars();
        return _carFormatter.getCarsNames(cars);
    }

    public Car getBestCar()
    {
        List<Car> cars = _carRepository.getAllCars();
        return _carSelection.getBestCar(cars);
    }
}