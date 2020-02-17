package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Data
public class Contact {
    private String firstName;
    private String surName;
    private String middleName;
    private Date dateOfBirth;
    private Sex sex;
    private String citizenship;
    private MaritalStatus maritalStatus;
    private String webSite;
    private String email;
    private String placeOfWork;
    private Adress adress;


}
