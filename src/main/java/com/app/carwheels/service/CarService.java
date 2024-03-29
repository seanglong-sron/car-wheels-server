package com.app.carwheels.service;

import java.util.List;
import java.util.Optional;

import com.app.carwheels.model.Car;

public interface CarService {
  public List<Car> getAllCars();
  public Optional<Car> getCarByName(String name);
  public Car createCar(Car car);
  public List<Car> getCarsByWheels(Long wheels);
}
