package es.taw.gestionbanco.controller;

// Autor: Juan Francisco Sánchez García

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping("/")
    public String doInicio(){

        return "inicio";
    }

}
