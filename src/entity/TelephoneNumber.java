package entity;

import entity.enums.TypeOfPhone;
import lombok.*;

import java.io.Serializable;
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TelephoneNumber implements Serializable {
    private int id;
    private int codeOfCountry;
    private int codeOfOperator;
    private int phoneNumber;
    private TypeOfPhone typeOfPhone;
    private String commentary;

    @Override
    public String toString() {
        return String.valueOf(codeOfCountry)+String.valueOf(codeOfOperator)+String.valueOf(phoneNumber);
    }
}
