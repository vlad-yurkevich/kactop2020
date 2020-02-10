package by.stm.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//--Тип трансмиссии
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarGearBoxType {
    private int id;
    private String name;
}
