package pl.sda.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.model.Trip;
import pl.sda.model.User;
import pl.sda.service.TripService;

@Controller
@RequestMapping("/trips")
@Slf4j
public class TripController {
    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }


    @GetMapping("/all")
    public ModelAndView tripList() {
        ModelAndView modelAndView = new ModelAndView("trip_list"); //nazwa widoku .html
        modelAndView.addObject("trips", tripService.getAll());
        return modelAndView;
    }

    @GetMapping("/add")
    public String addTrip(Model model) {
        model.addAttribute("trip", new Trip());
        log.info("Information acquired ");
        return "/trip_form";
    }

    @PostMapping("/add")
    public String addedTrip(@ModelAttribute Trip trip) {
        log.info(trip.toString());
        log.info("Registered");
        tripService.save(trip);
        return "redirect:/trips/all";
    }


    @GetMapping("/{tripId}")
    public ModelAndView tripPage(@PathVariable Integer tripId) {
        ModelAndView modelAndView = new ModelAndView("trip_page");
        modelAndView.addObject("trip", tripService.getById(tripId));
        return modelAndView;
    }

    @GetMapping("/delete")
    public String deleteTrip(Model model) {
        model.addAttribute("id", new String());
        log.info("Information acquired");
        return "/trip_remove";
    }

    @PostMapping("/delete")
    public String deletedTrip(@RequestParam("id") Integer id) {
        log.info("Acquired id: " + id);
        tripService.delete(id);
        log.info("removed");
        return "redirect:/trips/all";
    }

    @GetMapping("/mainpage")
    public ModelAndView mainpage() {
        ModelAndView modelAndView = new ModelAndView("mainpage"); //nazwa widoku .html
        return modelAndView;
    }

    @GetMapping("/buy/{tripId}")
    public ModelAndView buyTrip(@PathVariable Integer tripId) {
        ModelAndView modelAndView = new ModelAndView("trip_buy");
        modelAndView.addObject("trip", tripService.getById(tripId));
        return modelAndView;

    }

    @PostMapping("/buy/{tripId}")
    public String boughtTrip(@AuthenticationPrincipal User user, @RequestParam("tripIdForm") String tripId, @RequestParam("value") Integer value) {
       // tripService.buyTrip(user, trip);
        log.info(user + " " + tripService.getById(Integer.valueOf(tripId)));
        return "redirect:/trips/all";
    }

}
