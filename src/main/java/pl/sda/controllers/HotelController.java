package pl.sda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.model.Hotel;
import pl.sda.model.Trip;
import pl.sda.model.User;
import pl.sda.service.HotelService;

@Controller
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/{hotelId}")
    public ModelAndView hotelPage (@PathVariable Integer hotelId) {
        ModelAndView modelAndView = new ModelAndView("hotel_page");
        modelAndView.addObject("hotel", hotelService.getById(hotelId));
        return modelAndView;
    }

    @GetMapping("/addHotel")
    public String addHotel (Model model) {
        model.addAttribute("hotel", new Hotel());
        return "hotel_form";

    }

    @PostMapping("/addHotel")
    public String addedHotel(@ModelAttribute Hotel hotel){
        hotelService.save(hotel);
        return  "redirect:/hotels/all";
    }


    @GetMapping("/all")
    public ModelAndView hotelList () {
        ModelAndView modelAndView = new ModelAndView("hotel_list"); //nazwa widoku .html
        modelAndView.addObject("hotels", hotelService.getAll());
        return modelAndView;
    }

    @GetMapping("/delete")
    public String deleteHotel (Model model) {
        model.addAttribute("id", new String());
        return "/hotel_remove";
    }

    @PostMapping("/delete")
    public String deletedHotel (@RequestParam("id") Integer id) {
        hotelService.delete(id);
        return "redirect:/hotels/all";
    }


}
