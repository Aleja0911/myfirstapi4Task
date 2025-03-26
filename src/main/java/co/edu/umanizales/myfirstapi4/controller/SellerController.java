package co.edu.umanizales.myfirstapi4.controller;

import co.edu.umanizales.myfirstapi4.Seller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/seller")
public class SellerController {

    @GetMapping
    public String getSeller() {
        Seller pepito = new Seller("2497272", "Pepito", "Suarez","Manizales",(byte) 34,'H');
        Seller Oscar = new Seller("1002800","Oscar","Parra","Cali",(byte) 24,'H');
        Seller Alejandra = new Seller("1002799", "Alejandra", "Diaz", "Medellin",(byte) 21,'M');
        Seller Diana = new Seller("849503","Diana","Patiño","Bogota",(byte) 42,'M');
        Seller Jose = new Seller("23495","Jose","Franco","Bogota",(byte) 18,'H');
        return "Seller";
    }
}
