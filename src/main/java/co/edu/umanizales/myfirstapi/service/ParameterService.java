package co.edu.umanizales.myfirstapi.service;
import co.edu.umanizales.myfirstapi.model.Parameter;
import co.edu.umanizales.myfirstapi.model.TypeDoc;
import co.edu.umanizales.myfirstapi.model.TypeProduct;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class ParameterService {
    private List<Parameter> parameters;

    @PostConstruct
    public void init() {
        parameters = new ArrayList<>();
    }

    public List<Parameter> getParametersByType(int type) {
        List<Parameter> result = new ArrayList<>();

        for (Parameter p : parameters) {
            switch (type) {
                case 1:
                    if (p instanceof TypeDoc) {
                        result.add(p);
                    }
                    break;
                case 2:
                    if (p instanceof TypeProduct) {
                        result.add(p);
                    }
                    break;
            }
        }

        return result;
    }
}