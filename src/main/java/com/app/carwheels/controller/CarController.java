package com.app.carwheels.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.carwheels.dto.req.CarRequestDTO;
import com.app.carwheels.dto.res.ResponseMessage;
import com.app.carwheels.model.Car;
import com.app.carwheels.service.CarService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cars")
@CrossOrigin(originPatterns = "*")
public class CarController {

  private final CarService carService;

  @GetMapping
  public ResponseEntity<ResponseMessage<List<Car>>> getCarsByWheels() {
    try {
      List<Car> carsList = carService.getAllCars();

      ResponseMessage<List<Car>> response = new ResponseMessage<>();
      response.setData(carsList);
      response.setMessage("Success");

      return ResponseEntity.ok(response);
    } catch (Exception e) {
      e.getStackTrace();
      return ResponseEntity.internalServerError().build();
    }
  }

  @GetMapping("/{name}")
  public ResponseEntity<ResponseMessage<Car>> getCarByName(@PathVariable String name) {
    try {
      Optional<Car> optionalCar = carService.getCarByName(name);

      ResponseMessage<Car> response = new ResponseMessage<>();
      
      if (optionalCar.isPresent()) {
        response.setData(optionalCar.get());
        response.setMessage("Success");

        return ResponseEntity.ok(response);
      } else {
        response.setData(null);
        response.setMessage("Not found");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
      }
    } catch (Exception e) {
      e.getStackTrace();
      return ResponseEntity.internalServerError().build();
    }
  }

  @PostMapping
  public ResponseEntity<ResponseMessage<Car>> createCar(@Valid @RequestBody CarRequestDTO carRequest) {
    try {

      Car car = new Car();
      car.setName(carRequest.getName());
      car.setWheels(carRequest.getWheels());

      Car createdCar = carService.createCar(car);

      ResponseMessage<Car> response = new ResponseMessage<>();
      response.setData(createdCar);
      response.setMessage("Success");

      return ResponseEntity.ok(response);
    } catch (Exception e) {
      e.getStackTrace();
      return ResponseEntity.internalServerError().build();
    }
  }

  @GetMapping("/wheels/{wheels}")
  public ResponseEntity<ResponseMessage<List<Car>>> getCarsByWheels(@PathVariable Long wheels) {
    try {
      List<Car> carsList = carService.getCarsByWheels(wheels);

      ResponseMessage<List<Car>> response = new ResponseMessage<>();
      response.setData(carsList);
      response.setMessage("Success");

      return ResponseEntity.ok(response);
    } catch (Exception e) {
      e.getStackTrace();
      return ResponseEntity.internalServerError().build();
    }
  }
}
