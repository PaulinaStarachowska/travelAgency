package pl.sda.service.impl;

import pl.sda.model.Hotel;
import pl.sda.repository.HotelRepository;
import pl.sda.service.HotelService;

import java.util.List;

public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }


    @Override
    public void save(Hotel hotel) {
        hotelRepository.save(hotel);

    }

    @Override
    public Hotel getById(Integer id) {
        return hotelRepository.getById(id);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        hotelRepository.deleteById(id);

    }
}
