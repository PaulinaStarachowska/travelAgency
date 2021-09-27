package pl.sda.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
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

    private int seatNumber;

    @ManyToMany
    private List<User> tripParticipants = new ArrayList<>();

    public void addParticipation (User user, int count){
        for (int i = 0; i < count; i++) {
            tripParticipants.add(user);
        }
    }

}
