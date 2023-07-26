package com.example.car.service;

import com.example.car.entity.CarsEntity;
import com.example.car.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsDetailsImpl implements CarsDetails {
    @Autowired
    private final CarsRepository carsRepository;
    @Autowired
    public CarsDetailsImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public CarsEntity saveCar(CarsEntity cars){
        return carsRepository.save(cars);
    }

    @Override
    public CarsEntity updateCar(Long carId, CarsEntity updatedCar) {
        CarsEntity existingCar = carsRepository.findById(carId)
                .orElseThrow(() -> new IllegalArgumentException("Car not found"));
        existingCar.setCompany(updatedCar.getCompany());
        existingCar.setModel(updatedCar.getModel());
        existingCar.setYear(updatedCar.getYear());
        existingCar.setPrice(updatedCar.getPrice());

        return carsRepository.save(existingCar);
    }

    @Override
    public void deleteCar(Long carId) {
        carsRepository.deleteById(carId);
    }

    @Override
    public CarsEntity getCarById(Long carId) {
        return carsRepository.findById(carId)
                .orElseThrow(() -> new IllegalArgumentException("Car not found"));
    }

    @Override
    public List<CarsEntity> getAllCars() {
        return carsRepository.findAll();
    }

}
