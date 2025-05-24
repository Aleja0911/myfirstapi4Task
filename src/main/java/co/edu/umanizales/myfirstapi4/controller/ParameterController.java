package co.edu.umanizales.myfirstapi4.controller;


import co.edu.umanizales.myfirstapi4.model.Parameter;
import co.edu.umanizales.myfirstapi4.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="parameter")
public class ParameterController {

    @Autowired
    private ParameterService parameterService;


    @GetMapping(path="/typedocuments")
    public List<Parameter> getTypeDocuments() {
        return parameterService.getParametersByType(1);
    }

    @GetMapping(path="/typeproducts")
    public List<Parameter> getTypeProducts() {
        return parameterService.getParametersByType(2);
    }

    @GetMapping(path="/products")
    public List<Parameter> getProducts() {
        return parameterService.getParametersByType(3);
    }


    @GetMapping(path="bycode")
    public List<Parameter> getTypeByDocumentCode() {
        return parameterService.getParametersByType(4);
    }

}
