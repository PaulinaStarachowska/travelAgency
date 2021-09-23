package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {
}
