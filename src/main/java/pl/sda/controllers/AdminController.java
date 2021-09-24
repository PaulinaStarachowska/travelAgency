package pl.sda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.service.UserService;

@Controller
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/panel")
    public String adminPanel() {
        return "admin_panel";
    }

    @GetMapping("/{userId}")
    public ModelAndView userPanel(@PathVariable Integer userId) {
        ModelAndView modelAndView = new ModelAndView("admin_panel");
        modelAndView.addObject("user", userService.getById(userId));
        return modelAndView;

    }
}
