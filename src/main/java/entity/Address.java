package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;


@EqualsAndHashCode
@AllArgsConstructor
@Data
public class Address implements Serializable {
    private String country;
    private String city;
    private String street;
    private int numberOfBuilding;
    private int flat;

    @Override
    public String toString() {
        return country +" "+
                city + " " +
                street + " " +
                numberOfBuilding +
                " " + flat;
    }
}
