package by.stm.controller;

import by.stm.domain.Car;
import by.stm.domain.CarBrandType;
import by.stm.service.BaseReference;
import by.stm.service.BaseReferenceImpl;
import by.stm.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class CarController {

    @Autowired
    private BaseReference baseReference;

    @Autowired
    private CarService carService;

    List<CarBrandType> carBrandTypes = new ArrayList<>();


    @GetMapping(value = "/car/brand")
    public String carList1(Model model){
        model.addAttribute("serverTime", new Date());
        model.addAttribute("carBrands", baseReference.getList(BaseReferenceImpl.REF_BRAND));
        model.addAttribute("achievements", baseReference.getList(BaseReferenceImpl.REF_ACHIVMENT));
        model.addAttribute("brand", new CarBrandType());
        return "carbrand";
    }

    @PostMapping(value = "/car/addBrand")
    public String addCar(@ModelAttribute(value = "achievementsId") int achievementsId, Model model,
                         @ModelAttribute(value = "brand") CarBrandType thisBrand,
                         @RequestBody String note) {
        carBrandTypes.add(thisBrand);
        model.addAttribute("serverTime", new Date());
        model.addAttribute("carBrands",  baseReference.getList(BaseReferenceImpl.REF_BRAND));
        model.addAttribute("brand", new CarBrandType());
        return "carbrand";
    }

    @GetMapping(value = "/NewCar")
    public String carList(Model model){
        List<CarBrandType> listBrand = baseReference.getList(BaseReferenceImpl.REF_BRAND);
        model.addAttribute("carBrand", listBrand);
        int id_brand = 0;
        if (listBrand.size() > 0) { id_brand = listBrand.get(0).getId(); }
        model.addAttribute("id_brand", id_brand);
        model.addAttribute("CarModel",  baseReference.getListByParentId(BaseReferenceImpl.REF_MODEL, id_brand));
        model.addAttribute("carWheelDrive", baseReference.getList(BaseReferenceImpl.REF_WHEELDRIVE));
        model.addAttribute("carEngineType", baseReference.getList(BaseReferenceImpl.REF_ENGINE));
        model.addAttribute("carAccelerationType", baseReference.getList(BaseReferenceImpl.REF_ACCELERATION));
        model.addAttribute("carBoostType", baseReference.getList(BaseReferenceImpl.REF_BOOST));
        model.addAttribute("carGearBoxType", baseReference.getList(BaseReferenceImpl.REF_GEARBOX));
        model.addAttribute("carPrevailingColorType", baseReference.getList(BaseReferenceImpl.REF_PREVAILINGCOLOR));
        boolean myBooleanVariable = false;
        model.addAttribute("myBooleanVariable", myBooleanVariable);
        model.addAttribute("car", new Car());
        return "addCar";
    }

    @PostMapping(value = "/car/add")
    public String addCar(@ModelAttribute(value = "car") Car car, Model model, @RequestBody String note) {
        carService.addCar(car);
        model.addAttribute("car", new Car());
        return "addCar";
    }

    @PostMapping (value = "/car/refresh")
    public String refreshCar(@ModelAttribute(value = "car") Car car, @RequestParam(value = "id_brand") int id_brand, Model model, @RequestBody String note) {
        model.addAttribute("id_brand", id_brand);
        model.addAttribute("carBrand", baseReference.getList(BaseReferenceImpl.REF_BRAND));
        model.addAttribute("CarModel",  baseReference.getListByParentId(BaseReferenceImpl.REF_MODEL, id_brand));
        model.addAttribute("id_wheeldrive", car.getId_driveT());
        model.addAttribute("carWheelDrive", baseReference.getList(BaseReferenceImpl.REF_WHEELDRIVE));
        model.addAttribute("id_enginetype", car.getId_engineT());
        model.addAttribute("carEngineType", baseReference.getList(BaseReferenceImpl.REF_ENGINE));
        model.addAttribute("id_accelerationtype", car.getId_accelerationT());
        model.addAttribute("carAccelerationType", baseReference.getList(BaseReferenceImpl.REF_ACCELERATION));
        model.addAttribute("id_boosttype", car.getId_boostT());
        model.addAttribute("carBoostType", baseReference.getList(BaseReferenceImpl.REF_BOOST));
        model.addAttribute("id_gearboxtype", car.getId_gearBoxT());
        model.addAttribute("carGearBoxType", baseReference.getList(BaseReferenceImpl.REF_GEARBOX));
        model.addAttribute("id_prevailingcolortype", car.getId_prevailingColorT());
        model.addAttribute("carPrevailingColorType", baseReference.getList(BaseReferenceImpl.REF_PREVAILINGCOLOR));
        model.addAttribute("car", car);
        return "addCar";
    }
}
