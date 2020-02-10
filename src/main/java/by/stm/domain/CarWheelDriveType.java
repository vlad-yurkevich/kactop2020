package by.stm.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//--Привод автомобиля
public class CarWheelDriveType {
    private int id;
    private String name;
}
