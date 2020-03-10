package by.stm.controller;

import by.stm.domain.Car;
import by.stm.domain.CarBrandType;
import by.stm.service.BaseReference;
import by.stm.service.BaseReferenceImpl;
import by.stm.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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


    @GetMapping(value = "/car/brand")
    public String carList1(Model model){
        model.addAttribute("serverTime", new Date());
        model.addAttribute("carBrands", baseReference.getList(BaseReferenceImpl.REF_BRAND));
        model.addAttribute("achievements", baseReference.getList(BaseReferenceImpl.REF_ACHIVMENT));
        model.addAttribute("brand", new CarBrandType());
        return "carbrand";
    }

    @PostMapping(value = "/car/addBrand")
    public String addCar(@ModelAttribute(value = "carBrands") CarBrandType thisBrand, Model model, @RequestBody String note) {
        //carBrandTypes.add(thisBrand);
        model.addAttribute("serverTime", new Date());
        model.addAttribute("carBrands",  baseReference.getList(BaseReferenceImpl.REF_BRAND));
        model.addAttribute("brand", new CarBrandType());
        return "carbrand";
    }

    @GetMapping(value = "/NewCar")
    public String carList(Model model){
        model.addAttribute("car", new Car());
        return "addCar";
    }

    @PostMapping(value = "/car/add")
    public String addCar(@ModelAttribute(value = "car") Car car, Model model, @RequestBody String note) {
        carService.addCar(car);
        model.addAttribute("car", new Car());
        return "addCar";
    }
}
