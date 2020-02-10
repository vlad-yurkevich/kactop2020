package by.stm.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
class Achievement {
    private int count; //--Количество достижений
    private int id_achievementT; //--Достижение
    private int id_trackList; //--Номер треклиста
    private  int id_activity; //--Номер активности, не связанной с треклистом
    public Achievement(){
        count = 0;
        id_achievementT = -1;
        id_trackList = -1;
        id_activity = -1;
    }
}
