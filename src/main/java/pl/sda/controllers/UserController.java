package pl.sda.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.model.User;
import pl.sda.service.UserService;


@Controller
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ModelAndView userPanel(@PathVariable Integer userId) {
        ModelAndView modelAndView = new ModelAndView("user_panel");
        modelAndView.addObject("user", userService.getById(userId));
        return modelAndView;
    }

    @GetMapping("/register")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "user_registration_form_page";
    }

    @PostMapping("/register")
    public String addedUser(@ModelAttribute User user){
        log.info(user.toString());
        userService.save(user);
        log.info("User saved successfully");
        return  "redirect:/users/" + user.getId();
    }
}


//    @GetMapping("/trips/logout")
//    public String tripsAll(){
//        return "trip_list";
//    }

