package co.edu.umanizales.myfirstapi4.controller;
import co.edu.umanizales.myfirstapi4.model.Seller;
import co.edu.umanizales.myfirstapi4.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping
    public List<Seller> getAllSeller() {
        return sellerService.getAllSeller();
    }
}