package co.edu.umanizales.myfirstapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Store  {
    private String code;
    private String name;
    private String address;
    private String city;
}