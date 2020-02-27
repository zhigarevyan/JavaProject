package entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.enums.MaritalStatus;
import entity.enums.Sex;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Contact implements Serializable {
    private int id;
    private String firstName;
    private String surName;
    private String middleName;
    private Date dateOfBirth;
    private Sex sex;
    private String citizenship;
    private MaritalStatus maritalStatus;
    private String webSite;
    private String email;
    private Address address;
    private String placeOfWork;

    public void setAddress(String s) {
        String[] split = s.split(" ");
        Address address = new Address(split[0],split[1],split[2],Integer.parseInt(split[3]),Integer.parseInt(split[4]));
        this.address = address;
    }

}

