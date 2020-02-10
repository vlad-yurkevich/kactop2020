package by.stm.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//--Встреча
public class Meeting {
    private int id;
    private int id_sender; //--Отрпавитель
    private int id_senderCar; //--Машина отправителя (необязательно)
    private int id_recipient; //--Получатель
    private int recipientCar; //--Сашина получателя (необязательно)
    private int id_purposeT; //--Тип встречи
    private BigDecimal latitude; private BigDecimal longitude; //--Координаты
    private Date dateMeeting; //--Дата встречи
    private int status; //--(1 - ожидается ответ получателя, 2 - ожидается ответ отправителя, 3 - принято обоими, 4 - вышел срок)
}
