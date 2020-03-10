package by.stm.service;

import by.stm.domain.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    //--Константы ошибок
    private final String ERR_CAR_NOT_FOUND = "Автомобиль с таким номером не найден";

    private List<Car> carList = new ArrayList<>();
    private String lastError = "";

    @Override
    public List getCarList() {
        return carList;
    }

    @Override
    public Car getCarById(int idCar) {
        Car result = null;
        if (idCar > 0 && idCar <= carList.size()){ result = carList.get(idCar); }
        else { lastError = ERR_CAR_NOT_FOUND; }
        return result;
    }

    @Override
    public boolean addCar(Car newCar) {
        //--пока с базой не работаем - игнорируем ошибки
        boolean result = true;
        carList.add(newCar);
        return result;
    }

    @Override
    public boolean editCar(int idCar, Car editedCar) {
        //--пока с базой не работаем - игнорируем ошибки
        boolean result = true;
        carList.add(idCar, editedCar);
        return result;
    }

    @Override
    public boolean delCar(int idCar) {
        //--пока с базой не работаем - игнорируем ошибки
        boolean result = true;
        carList.remove(idCar);
        return false;
    }

    @Override
    public String getLastError() {
        return lastError;
    }
}
