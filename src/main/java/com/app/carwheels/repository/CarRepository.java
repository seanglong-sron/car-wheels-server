package com.app.carwheels.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.carwheels.model.Car;
import java.util.List;
import java.util.Optional;


@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
  Optional<Car> findByName(String name);
  List<Car> findByWheels(Long wheels);
}
