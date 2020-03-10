package by.stm.service;

import by.stm.domain.*;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BaseReferenceImpl implements BaseReference {
    //--Константы для справочников
    public static final int REF_BRAND = 0;
    public static final int REF_ACHIVMENT = 1;
    public static final int REF_ACCELERATION = 2;
    public static final int REF_BOOST = 3;
    public static final int REF_DISCIPLINE = 4;
    public static final int REF_ENGINE = 5;
    public static final int REF_GEARBOX = 6;
    public static final int REF_MODEL = 7;
    public static final int REF_PREVAILINGCOLOR = 8;
    public static final int REF_WHEELDRIVE = 9;
    public static final int REF_PURPOSE = 10;
    //--Список справочников
    List<AchievementsType> achievementsTypeList = new ArrayList<>();
    List<CarAccelerationType> carAccelerationTypeList = new ArrayList<>();
    List<CarBoostType> carBoostTypeList = new ArrayList<>();
    List<CarBrandType> carBrandTypeList = new ArrayList<>();
    List<CarDisciplineType> carDisciplineTypeList = new ArrayList<>();
    List<CarEngineType> carEngineTypeList = new ArrayList<>();
    List<CarGearBoxType> carGearBoxTypeList = new ArrayList<>();
    List<CarModelType> carModelTypeList = new ArrayList<>();
    List<CarPrevailingColorType> carPrevailingColorTypeList = new ArrayList<>();
    List<CarWheelDriveType> carWheelDriveTypeList = new ArrayList<>();
    List<PurposeType> purposeTypeList = new ArrayList<>();

    @PostConstruct
    public void init(){
        //--Заполняем бренды автомобилей
        final Random random = new Random();
        carBrandTypeList.add(
                CarBrandType.builder()
                        .id(random.nextInt(1))
                        .name("BMW")
                        .build()
        );
        carBrandTypeList.add(
                CarBrandType.builder()
                        .id(random.nextInt(2))
                        .name("Mercedes")
                        .build()
        );
        carBrandTypeList.add(
                CarBrandType.builder()
                        .id(random.nextInt(3))
                        .name("Audi")
                        .build()
        );
        //--Заполняем типы ускорителей
        carAccelerationTypeList.add(new CarAccelerationType(1, "Без ускорителей"));
        carAccelerationTypeList.add(new CarAccelerationType(2, "Закись азота"));
        carAccelerationTypeList.add(new CarAccelerationType(3, "Водометанол"));
        carAccelerationTypeList.add(new CarAccelerationType(4, "Азот+Водометанол"));
        carAccelerationTypeList.add(new CarAccelerationType(5, "Электро-ускоритель"));
        carAccelerationTypeList.add(new CarAccelerationType(6, "Реактивный форсаж"));
        //--Наддув
        carBoostTypeList.add(new CarBoostType(1, "Без наддува"));
        carBoostTypeList.add(new CarBoostType(2, "С турбо/компрессором"));
        carBoostTypeList.add(new CarBoostType(3, "С двойным наддувом"));
        carBoostTypeList.add(new CarBoostType(4, "С тройным наддувом"));
        carBoostTypeList.add(new CarBoostType(5, "С четверным наддувом"));
        //--Трансмиссия
        carGearBoxTypeList.add(new CarGearBoxType(1, "Механическая КПП"));
        carGearBoxTypeList.add(new CarGearBoxType(2, "Автоматическая КПП"));
        carGearBoxTypeList.add(new CarGearBoxType(3, "Роботизированная КПП"));
        carGearBoxTypeList.add(new CarGearBoxType(4, "Секвентальная КПП"));
        carGearBoxTypeList.add(new CarGearBoxType(5, "Вариатор"));
        carGearBoxTypeList.add(new CarGearBoxType(6, "Прямой привод на редуктор"));
        //--Двигатель
        carEngineTypeList.add(new CarEngineType(1, "Бензиновый двигатель"));
        carEngineTypeList.add(new CarEngineType(2, "Дизельный двигатель"));
        carEngineTypeList.add(new CarEngineType(5, "Газовый двигатель"));
        carEngineTypeList.add(new CarEngineType(5, "Многотопливный двигатель"));
        carEngineTypeList.add(new CarEngineType(4, "Гибридный двигатель"));
        carEngineTypeList.add(new CarEngineType(3, "Электродвигатель"));
        //--Модели
        carModelTypeList.add(new CarModelType(1, 1, "M3"));
        carModelTypeList.add(new CarModelType(2, 1, "M5"));
        carModelTypeList.add(new CarModelType(3, 1, "740d"));
        carModelTypeList.add(new CarModelType(4, 2, "E220"));
        carModelTypeList.add(new CarModelType(5, 2, "ML350"));
        carModelTypeList.add(new CarModelType(6, 2, "S500"));
        carModelTypeList.add(new CarModelType(7, 3, "A7 RS"));
        carModelTypeList.add(new CarModelType(8, 3, "AllRoad"));
        carModelTypeList.add(new CarModelType(9, 3, "A 8"));
        //--Преобладающий цвет
        carPrevailingColorTypeList.add(new CarPrevailingColorType(0, "Переменный")); //--Хамелеон
        carPrevailingColorTypeList.add(new CarPrevailingColorType(1, "Красный"));
        carPrevailingColorTypeList.add(new CarPrevailingColorType(2, "Желтый"));
        carPrevailingColorTypeList.add(new CarPrevailingColorType(3, "Зелёный"));
        carPrevailingColorTypeList.add(new CarPrevailingColorType(4, "Прозрачный")); //--Стекловолокно
        //--Тип привода
        carWheelDriveTypeList.add(new CarWheelDriveType(1, "Передний привод"));
        carWheelDriveTypeList.add(new CarWheelDriveType(2, "Задний привод"));
        carWheelDriveTypeList.add(new CarWheelDriveType(3, "Полный привод"));
        carWheelDriveTypeList.add(new CarWheelDriveType(4, "Гусеничный привод"));
        //--Дисциплины
        carDisciplineTypeList.add(new CarDisciplineType(1, "Автобои на выживание"));
        carDisciplineTypeList.add(new CarDisciplineType(2, "Ускорение по прямой"));
        carDisciplineTypeList.add(new CarDisciplineType(3, "Управляемые заносы"));
        carDisciplineTypeList.add(new CarDisciplineType(4, "Фигурное маневрирование"));
        carDisciplineTypeList.add(new CarDisciplineType(5, "Гонки на выносливость"));
        carDisciplineTypeList.add(new CarDisciplineType(6, "Ралли"));
        carDisciplineTypeList.add(new CarDisciplineType(7, "Кольцевые гонки"));
        carDisciplineTypeList.add(new CarDisciplineType(8, "Заезды на время по точкам"));
        carDisciplineTypeList.add(new CarDisciplineType(9, "Триалы"));
        carDisciplineTypeList.add(new CarDisciplineType(10, "Трофи"));
        carDisciplineTypeList.add(new CarDisciplineType(11, "Выставки и шоу"));
        //--Достижения
        achievementsTypeList.add(new AchievementsType(1, "ЭКСПАНСИСТ (пригласить нового участника на соревнование)"));
        achievementsTypeList.add(new AchievementsType(2, "ПОВЕЛИТЕЛЬ МАЛОЛИТРАЖЕК (победить на машине с ДВС объемом < 1,8л.)"));
        achievementsTypeList.add(new AchievementsType(3, "МАРШРУТЧИК (победить на микроавтобусе, кроме специализированных соревнований)"));
        achievementsTypeList.add(new AchievementsType(4, "Д'АРТАНЬЯН ДНЯ (победить в большинстве \"дуэлей\" в итечение суток)"));
        achievementsTypeList.add(new AchievementsType(5, "В ТИХОМ ОМУТЕ (установить рекорд трассы во время соло-тренировки, с обязательным видео-подтверждением)"));
        achievementsTypeList.add(new AchievementsType(6, "КАМНЕТЕС (разбить бордюр, плиту или перекрытие, доехав до финиша)"));
        achievementsTypeList.add(new AchievementsType(7, "ДИЗАЙНЕР ЛАНДШАФТА (снести дерево, доехав до финиша)"));
        achievementsTypeList.add(new AchievementsType(8, "ПОЧЕТНЫЙ ВЕГАН (сбить зверушку, доехав до финиша)"));
        achievementsTypeList.add(new AchievementsType(9, "ИСКРОМЕТ (искры из тормозов или покрышек в процессе прохождения трассы, доехав до финиша)"));
        achievementsTypeList.add(new AchievementsType(10, "ПАРОВОЗ (финишировать с дымовой завесой из под капота)"));
        achievementsTypeList.add(new AchievementsType(11, "ТОЛЧОК ПОБЕДЫ (протолкать машину до финиша)"));
        achievementsTypeList.add(new AchievementsType(12, "ГЕРОЙ-ЛЮБОВНИК (умудриться \"заняться\" в течение мероприятия)"));
        achievementsTypeList.add(new AchievementsType(13, "РОЖДЕН В РУБАШКЕ (вылететь в кювет при прохождении трассы, не повредив машину)"));
        achievementsTypeList.add(new AchievementsType(14, "ГЕРОЙ УДАРНОГО ПРОИЗВОДСТВА (повредить свою машину в процессе тестирования новой трассы)"));
        achievementsTypeList.add(new AchievementsType(15, "ГОРЯЧЕЕ ПРЕСЛЕДОВАНИЕ (финишировать с мигалками \"на хвосте\")"));
        achievementsTypeList.add(new AchievementsType(16, "С ДНЕМ РОЖДЕНИЯ! (\"проставить\" день рождения на мероприятии, при совпадении с викендом проведения)"));
        achievementsTypeList.add(new AchievementsType(17, "РУКИ ИЗ АДА (повредить машину другого участника своей при прохождении трассы)"));
        achievementsTypeList.add(new AchievementsType(18, "ВПЕРЕД В ПРОШЛОЕ (подвернуть все колеса одной стороны внутрь - \"антистэнс\")"));
        achievementsTypeList.add(new AchievementsType(19, "ВЕСЬМА ЗАНОСЧИВ (проехать всю не-дрифтовую конфигурацию в непрерывном заносе)"));
        achievementsTypeList.add(new AchievementsType(20, "НАСТОЯЩИЙ ЖЕЛЕЗНОДОРОЖНИК (\"разуть\" колесо машины в процессе заезда, доехав до финиша)"));
        achievementsTypeList.add(new AchievementsType(21, "ПУШКА-ХЛОПУШКА (взорвавшаяся покрышка во время прохождения трассы, имея зачетный результат)"));
        achievementsTypeList.add(new AchievementsType(22, "ОШИБКА САПЕРА (то же самое, но кроме шин)"));
        achievementsTypeList.add(new AchievementsType(23, "АМЕРИКАНСКИЙ ДРИФТ (проехать всю drag-дистанцию в непрерывном заносе или \"змейкой\")"));
        achievementsTypeList.add(new AchievementsType(24, "БОКОВОЙ ПРИВОД (подняться на колеса одной стороны в процессе прохождения трассы, доехав до финиша, при отсутствии специальных рамп и вне специализированных соревнований)"));
        achievementsTypeList.add(new AchievementsType(25, "СВОЙ В ДОСКУ (победить \"служебном\" автомобиле со спецсимволикой)"));
        achievementsTypeList.add(new AchievementsType(26, "ОДИН ЗА ВСЕХ (победить, являясь представителем команды своего клуба)"));
        achievementsTypeList.add(new AchievementsType(27, "ЭТО ДИАГНОЗ (принять участие в 5 мероприятиях подряд)"));
        achievementsTypeList.add(new AchievementsType(28, "НЕУДЕРЖИМЫЙ (утратить колесо или агрегат или кузовной элемент, доехав до финиша)"));
        achievementsTypeList.add(new AchievementsType(29, "ПОБЕДИТЕЛЬ ПО ЖИЗНИ (повредить свою машину после пересечения финиша)"));
        achievementsTypeList.add(new AchievementsType(30, "АДЕПТ КЕНА БЛОКА (сделать разворот 360 градусов на скорости в time attack\\time trial доехав до финиша)"));
        achievementsTypeList.add(new AchievementsType(31, "КОБРА ЭСЭС (проехать более 100м drag-дистанции на задних колесах)"));
        achievementsTypeList.add(new AchievementsType(32, "ВАСТЭД (утратить пассажира в процессе прохождения трассы)"));
        achievementsTypeList.add(new AchievementsType(33, "ВНЕ КОНТРОЛЯ (оторвать руль во время заезда)"));
        achievementsTypeList.add(new AchievementsType(34, "ЗОВ ПРИРОДЫ (утопить машину в водоеме при прохождении трассы)"));
        achievementsTypeList.add(new AchievementsType(35, "ВЕРТУХАЙ (перевернуться в процессе прохождения трассы, остаться на колесах)"));
        achievementsTypeList.add(new AchievementsType(36, "БОЛИВУД (перевернуться в процессе прохождения трассы, остаться на колесах и продолжить гонку)"));
        achievementsTypeList.add(new AchievementsType(37, "РЕЖИССЕР-ГОСПОДЬ (успеть снять полноценный официальный видео-отчет безотрывно от участия в гонках)"));
        achievementsTypeList.add(new AchievementsType(38, "ЧЕЛОВЕК-ГВОЗДЬ (повредить свою машину в трех гонках подряд, с получением зачетного результата"));
        //--Типы встреч
        purposeTypeList.add(new PurposeType(1, "Приглашение на мероприятие"));
        purposeTypeList.add(new PurposeType(2, "Вызов один-на-один"));
        purposeTypeList.add(new PurposeType(3, "Общение/чай/кофе"));
        purposeTypeList.add(new PurposeType(4, "Переговоры о команде"));
        purposeTypeList.add(new PurposeType(5, "Предложение по съёмке"));

 }

    @Override
    public String getValue(int idRef, int idValue) {
        return null;
    }

    @Override
    public List getList(int idRef) {
        switch (idRef){
            case REF_BRAND:{ return carBrandTypeList; }
            case REF_ACHIVMENT:{ return achievementsTypeList; }
            case REF_ACCELERATION:{ return carAccelerationTypeList; }
            case REF_BOOST:{ return carBoostTypeList; }
            case REF_DISCIPLINE:{ return carDisciplineTypeList; }
            case REF_ENGINE:{ return carEngineTypeList; }
            case REF_GEARBOX:{ return carGearBoxTypeList; }
            case REF_MODEL:{ return carModelTypeList; }
            case REF_PREVAILINGCOLOR:{ return carPrevailingColorTypeList; }
            case REF_WHEELDRIVE:{ return carWheelDriveTypeList; }
            case REF_PURPOSE:{ return purposeTypeList; }
            default:{return null;}
        }
    }

    @Override
    public void doRefresh(int idRef) {

    }
}
