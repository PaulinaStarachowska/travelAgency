package pl.sda.service;

import pl.sda.model.Trip;

import java.util.List;

public interface TripService {

    void save(Trip trip);

    Trip getById(Integer id);

    List<Trip> getAll();

    void delete(Integer id);
}
