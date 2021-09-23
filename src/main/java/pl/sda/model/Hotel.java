package pl.sda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String hotelName;
    private String hotelCountry;
    private String hotelCity;

//    public void setHotelName (String hotelName){this.hotelName=hotelName;}
//    public void setHotelCountry (String hotelCountry){this.hotelCountry=hotelCountry;}
//    public void setHotelCity (String hotelCity){this.hotelCity=hotelCity;}
}
