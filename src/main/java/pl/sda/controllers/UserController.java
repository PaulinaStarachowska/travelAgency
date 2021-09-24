package pl.sda.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.model.Role;
import pl.sda.model.User;
import pl.sda.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
        userService.encodePassword(user);
        user.setUserType(Role.ADMIN);
        userService.save(user);
        log.info("User saved successfully");
        return  "redirect:/users/" + user.getId();
    }
    @GetMapping("/all")
    public ModelAndView userList() {
        ModelAndView modelAndView = new ModelAndView("user_list"); //nazwa widoku .html
        modelAndView.addObject("users", userService.getAll());
        return modelAndView;
    }

    @GetMapping("/delete")
    public String deleteUser(Model model) {
        model.addAttribute("id", new String());
        log.info("Information acquired");
        return "/user_remove";
    }

    @PostMapping("/delete")
    public String deletedUser(@RequestParam("id") Integer id) {
        log.info("Acquired id: " + id);
        userService.delete(id);
        log.info("removed");
        return "redirect:/users/all";
    }

//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response){
//        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication != null){
//            new SecurityContextLogoutHandler().logout(request,response,authentication);
//        }
//
//        return "redirect:/index";
//    }
}


//    @GetMapping("/trips/logout")
//    public String tripsAll(){
//        return "trip_list";
//    }

