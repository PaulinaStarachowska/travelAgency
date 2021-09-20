package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.model.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip,Integer> {


}
