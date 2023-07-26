package com.example.car.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cars_details")
public class CarsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carId;
    private String company;
    private String model;
    private int year;
    private double price;

    public void setCompany(String company) {
        this.company = company;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + carId +
                ", make='" + company + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
