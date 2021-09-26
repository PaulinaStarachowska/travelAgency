package pl.sda.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Trip {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String country;

    private String city;

    private String hotelName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate onboarding;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate offboarding;

    private BigDecimal price;

    @OneToMany
    private List<User> tripParticipants;

    public void Reservation(List<User> tripParticipants) {
        this.tripParticipants = tripParticipants;
    }

}
