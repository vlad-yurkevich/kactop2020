package by.stm.controller;

import by.stm.domain.CarBrandType;
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
    private List<CarBrandType> carBrandTypes = new ArrayList<>();

    @PostConstruct
    public void init(){
        final Random random = new Random();
        carBrandTypes.add(
                CarBrandType.builder()
                        .id(random.nextInt(10000))
                        .name("BMW")
                        .build()
        );
        carBrandTypes.add(
                CarBrandType.builder()
                        .id(random.nextInt(10000))
                        .name("Mercedes")
                        .build()
        );
        carBrandTypes.add(
                CarBrandType.builder()
                        .id(random.nextInt(10000))
                        .name("Audi")
                        .build()
        );
    }

    @GetMapping(value = "/car/brand")
    public String carList(Model model){
        model.addAttribute("serverTime", new Date());
        model.addAttribute("carBrands", carBrandTypes);
        model.addAttribute("brand", new CarBrandType());
        return "carbrand";
    }

    @PostMapping
    public String addCar(@ModelAttribute(value = "brand") CarBrandType thisBrand, Model model, @RequestBody String note) {
        carBrandTypes.add(thisBrand);
        model.addAttribute("serverTime", new Date());
        model.addAttribute("carBrands", carBrandTypes);
        model.addAttribute("brand", new CarBrandType());
        return "carbrand";
    }

}
