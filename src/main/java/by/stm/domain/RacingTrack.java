package by.stm.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RacingTrack {
    private int id;
    private String trackNme;

    //--Координаты
    private Double latitude; //--Широта
    private Double longitude; //--Долгота
    private String trackArea; //--Область охвата (например Минск - для Минска и окружности)

    private String trajectory; //--Конфигурация (ссылка на гуглМап)
    private String trackImagePath; //--Путь к картинке с траекторией (может наложение на фото)
    private int difficulty; //--Сложность трассы
    private Double distance; //--Длина трека
    private int id_disciplineType; //--Тип дисциплины (CarDisciplineType)
    private String trackAbout; //--Описание трека
    private boolean isConstant; //--Постоянная или временная (для разовых покатушек)
}
