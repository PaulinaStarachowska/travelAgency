package pl.sda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.service.UserService;


@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("user/{userId}")
    public ModelAndView userPanel(@PathVariable Integer userId) {
        ModelAndView modelAndView = new ModelAndView("user_panel");
        modelAndView.addObject("user", userService.getById(userId));
        return modelAndView;
    }
}


//    @GetMapping("/trips/logout")
//    public String tripsAll(){
//        return "trip_list";
//    }

