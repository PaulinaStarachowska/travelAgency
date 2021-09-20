package pl.sda.service.impl;

import pl.sda.model.Trip;
import pl.sda.repository.TripRepository;
import pl.sda.service.TripService;

import java.util.List;

public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;

    public TripServiceImpl(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public void save(Trip trip) {
        tripRepository.save(trip);
    }

    @Override
    public Trip getById(Integer id) {
        return tripRepository.getById(id);
    }

    @Override
    public List<Trip> getAll() {
        return tripRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        tripRepository.deleteById(id);
    }
}