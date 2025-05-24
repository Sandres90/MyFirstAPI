package co.edu.umanizales.myfirstapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/sale")
@RestController
public class SaleController {
    @GetMapping
    public String getSale() {


        return "Sale";
    }
}
