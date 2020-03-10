package by.stm.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//--пользователь
public class User {
    private int id;
    private int id_status;
    private String realName; //--Настоящие ФИО
    private String nickName; //--Псевдоним
    private String password; //--Пароль аккаунта
    private String imgPhotoPath; //--Фото пользователя
    private String imgBackgroundPath; //--Картинка для бэкграунда
    private String imgGarageViewPath; //--Картинка для гаража
    private String email; //--Электронный адрес пользователя
    private int gender; //--Пол(0 - мужской, 1 - женский)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date birthDay = new Date(); //--Дата рождения
    private String region; //--Регион ?
    private String place; //--Местоположение ?
    private String command; //--Команда ?
    private String reputation; //Репутация ?
    private int displayView; //--Отображать в профиле(0 - Реальное имя, 1 - Псевдоним)
    private int sound; //--Звук на сайте(0 - Выключено, >1 - включено)
    private int music; //--Музыка на сайте(0 - Выключено, >1 - включено)
    private int graphicLevel; //-- Уровень графики ?
    private int premium; //--Премиум-аккаунт 0/1
    private int id_disciplineT; //--Предпочитаемая дисциплина
    private int sendDisciplineResults; //--Оповещения о новых результатах в предпочитаемой дисциплине (0 - выкл, 1 - уведомления на сайте, 2 - уведомления на сайте и на почте)
    private int sendFriendResults; //--Оповещения о результатах друзей (0 - выкл, 1 - уведомления на сайте, 2 - уведомления на сайте и на почте)
    private int sendNewEventInfo; //--Оповещения о новых Мероприятиях (0 - выкл, 1 - уведомления на сайте, 2 - уведомления на сайте и на почте)
    private int activityZone; //--Зона активности (для приглашений на мероприятия и вызовов на гонку другими участниками)
    private int winTokens; //--Призовые жетоны
    private List<Achievement> achievements; //--Список достижений
    private List<Car> hangar; //--Автомобили пользователя
}
