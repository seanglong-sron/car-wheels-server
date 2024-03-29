package com.app.carwheels.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.app.carwheels.model.Car;
import com.app.carwheels.repository.CarRepository;
import com.app.carwheels.service.CarService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

  private final CarRepository carRepository;

  @Override
  public List<Car> getAllCars() {
    return carRepository.findAll();
  }

  @Override
  public Optional<Car> getCarByName(String name) {
    return carRepository.findByName(name);
  }

  @Override
  public Car createCar(Car car) {
    return carRepository.save(car);
  }

  @Override
  public List<Car> getCarsByWheels(Long wheels) {
    return carRepository.findByWheels(wheels);
  }
}
