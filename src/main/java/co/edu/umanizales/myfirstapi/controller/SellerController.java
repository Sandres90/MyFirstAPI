package co.edu.umanizales.myfirstapi.controller;

import co.edu.umanizales.myfirstapi.model.Seller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    @GetMapping
    public List<Seller> getSellers() {
        return Arrays.asList(
                new Seller("Carlos", 30, "Madrid", 1234.5),
                new Seller("Luis", 40, "Barcelona", 1500.0),
                new Seller("Maria", 35, "Milan", 1600.0),
                new Seller("Pedro", 28, "Francia", 1400.0),
                new Seller("Ana", 32, "Roma", 1700.0)
        );
    }
}
