package com.zetta.springexperiments.repository;

import com.zetta.springexperiments.entity.Car;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("select c from Car c where c.brand like :brand")
    List<Car> findAllByBrand(String brand);
    List<Car> findAllByColor(String color);
    List<Car> findAllByBuildYear(int year);
    List<Car> findAllByBrandAndColor(String brand, String Color);

}
