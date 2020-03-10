package by.stm.controller;

import by.stm.domain.User;
import by.stm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/NewUser")
    public String carList(Model model){
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping(value = "/user/add")
    public String addCar(@ModelAttribute(value = "user") User user, Model model, @RequestBody String note) {
        userService.addUser(user);
        model.addAttribute("user", new User());
        return "addUser";
    }
}
