package pl.sda.service;

import pl.sda.model.Hotel;
import pl.sda.model.Trip;

import java.util.List;

public interface HotelService {

    void save(Hotel hotel);

    Hotel getById(Integer id);

    List<Hotel> getAll();

    void delete(Integer id);
}

