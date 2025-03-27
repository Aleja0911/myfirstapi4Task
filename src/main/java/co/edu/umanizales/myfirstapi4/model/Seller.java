package co.edu.umanizales.myfirstapi4.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Seller {
    private String identification;
    private String name;
    private String lastName;
    private String city;
    private byte age;
    private char gender;
}
