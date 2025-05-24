package co.edu.umanizales.myfirstapi4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor

public class Sale {
    private String product;
    private String customer;
    private Date dateSale;
    private String formPayment;
}
