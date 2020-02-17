package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Data
public class Adress {
    private String country;
    private String city;
    private String street;
    private int numberOfBuilding;
    private int flat;
}
