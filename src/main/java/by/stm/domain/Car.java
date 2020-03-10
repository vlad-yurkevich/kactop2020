package by.stm.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//--Автомобиль
public class Car {
    private int id;
    private int id_modelT; //--Номер модели
    private String name; //--Псевдоним для фронта
    private int id_driveT; //--Привод (передний/задний...)
    private BigDecimal volume; //--Объём двигателя
    private int id_engineT; //--Двигатель (бензин/дизель...)
    private int estimatedPower; //--Расчётная мощность
    private int year; //--Год выпуска
    private int id_accelerationT; //--Ускорение
    private int id_boostT; //--Наддув
    private int id_gearBoxT; //--Трансмиссия
    private int id_prevailingColorT; //--Цвет
    private String imgCarPath; //--Путь к фото авто
    //--Основной автомобиль
    private int isPrimary; //--1 - основной
}
