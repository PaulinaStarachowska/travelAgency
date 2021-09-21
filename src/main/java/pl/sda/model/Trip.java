package pl.sda.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

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
}
