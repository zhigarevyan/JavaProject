package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Data
public class TelephoneNumber {
    private short codeOfCountry;
    private short codeOfOperator;
    private int phoneNumber;
    private TypeOfPhone typeOfPhone;
    private String commentary;
}
