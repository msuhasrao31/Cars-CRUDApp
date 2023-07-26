package com.example.car.service;

import com.example.car.entity.CarsEntity;

import java.util.List;

public interface CarsDetails {

    CarsEntity saveCar(CarsEntity car);
    CarsEntity updateCar(Long carId,CarsEntity updatedCar);
    void deleteCar(Long carId);
    CarsEntity getCarById(Long carId);

    List<CarsEntity> getAllCars();

}
