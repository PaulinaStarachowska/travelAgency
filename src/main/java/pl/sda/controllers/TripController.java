package pl.sda.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.repository.TripRepository;
import pl.sda.service.TripService;

@Controller
@RequestMapping("/trips")
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
    @GetMapping("/trips/{tripId}")
    public ModelAndView tripPage(@PathVariable Integer tripId) {
        ModelAndView modelAndView = new ModelAndView("trip_page");
        modelAndView.addObject("trip", tripService.getById(tripId));
        return modelAndView;
    }


}
