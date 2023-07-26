package com.example.car.controller;

import com.example.car.entity.CarsEntity;
import com.example.car.service.CarsDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarsController {
    @Autowired
    private final CarsDetails carsDetails;

    @Autowired
    public CarsController(CarsDetails carsDetails) {
        this.carsDetails = carsDetails;
    }

    @PostMapping
    public ResponseEntity<CarsEntity> createCar(@RequestBody CarsEntity car) {
        CarsEntity savedCar = carsDetails.saveCar(car);
        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }

    @GetMapping("/{carId}")
    public ResponseEntity<CarsEntity> getCarById(@PathVariable Long carId) {
        CarsEntity car = carsDetails.getCarById(carId);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CarsEntity>> getAllCars() {
        List<CarsEntity> cars = carsDetails.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @PutMapping("/{carId}")
    public ResponseEntity<CarsEntity> updateCar(@PathVariable Long carId, @RequestBody CarsEntity updatedCar) {
        CarsEntity car = carsDetails.updateCar(carId, updatedCar);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long carId) {
        carsDetails.deleteCar(carId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
