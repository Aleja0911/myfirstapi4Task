package co.edu.umanizales.myfirstapi4.service;
import co.edu.umanizales.myfirstapi4.model.Parameter;
import co.edu.umanizales.myfirstapi4.model.Product;
import co.edu.umanizales.myfirstapi4.model.TypeDoc;
import co.edu.umanizales.myfirstapi4.model.TypeProduct;
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
                case 3:
                    if(p instanceof Product){
                        result.add(p);
                    }
                    break;
                case 4:
                default:
                    System.out.println("El tipo ingresado no existe");
                    return result;
            }
        }
        if (result.isEmpty()){
            System.out.println("No se encontró información para el tipo ingresado");

        }
        return result;
    }

    public TypeDoc getTypeDocument(String type) {

        for (Parameter p : parameters) {
            if (p.getCode().equals(type)) {
                return (TypeDoc) p;
            }
        }
        return null;
    }

    public TypeProduct getTypeProduct(String type) {
        for (Parameter p : parameters) {
            if (p.getCode().equals(type)) {
                return (TypeProduct) p;
            }
        }
        return null;
    }
}