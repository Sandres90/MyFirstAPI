package co.edu.umanizales.myfirstapi.controller;

import co.edu.umanizales.myfirstapi.model.Sale;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @GetMapping
    public List<Sale> getSales() {
        return Arrays.asList(
                new Sale("Sale 001", 5000.0),
                new Sale("Sale 002", 12000.0),
                new Sale("Sale 003", 8000.0)
        );
    }
}
