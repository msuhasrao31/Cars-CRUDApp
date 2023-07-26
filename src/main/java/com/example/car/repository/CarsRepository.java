package com.example.car.repository;


import com.example.car.entity.CarsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsRepository extends JpaRepository<CarsEntity, Long> {

    List<CarsEntity> findByCompany(String company);
    List<CarsEntity> findByModel(String model);

    List<CarsEntity> findByYear(int year);
}
