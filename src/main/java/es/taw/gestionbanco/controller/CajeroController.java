package es.taw.gestionbanco.controller;

import es.taw.gestionbanco.dao.ClienteEntityRepository;
import es.taw.gestionbanco.dao.CuentaBancoRepository;
import es.taw.gestionbanco.entity.ClienteEntity;
import es.taw.gestionbanco.entity.CuentabancoEntity;
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
    @Autowired
    CuentaBancoRepository cuentaBancoRepository;

    @GetMapping("/")
    public String listaParametrosCuenta(@ModelAttribute("cliente") ClienteEntity cliente, Model model){
        CuentabancoEntity cuentabancoEntity = cuentaBancoRepository.parametrosCliente(cliente.getId());
        model.addAttribute(cuentabancoEntity);
        return "redirect:/";
    }
    @PutMapping ("/")
    public String modificaDatos(@ModelAttribute("cliente") ClienteEntity cliente){
      return "redirect:/";
    }
}
