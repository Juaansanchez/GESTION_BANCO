package es.taw.gestionbanco.controller;

import es.taw.gestionbanco.dao.ClienteEntityRepository;
import es.taw.gestionbanco.entity.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class CajeroController {
    @Autowired
    ClienteEntityRepository clienteEntityRepository;

    @GetMapping("/")
    public String listaParametrosCuenta(Model model){
        return "redirect:/";
    }
    @PutMapping ("/")
    public String modificaDatos(@ModelAttribute("cliente") ClienteEntity cliente){
      return "redirect:/";
    }
}
