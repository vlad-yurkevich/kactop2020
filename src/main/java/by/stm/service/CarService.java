package by.stm.service;

import by.stm.domain.Car;

import java.util.List;

public interface CarService {
    List getCarList();
    Car getCarById(int idCar);
    boolean addCar(Car newCar);
    boolean editCar(int idCar, Car editedCar);
    boolean delCar(int idCar);
    String getLastError();
}
