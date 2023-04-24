package es.taw.gestionbanco.controller;

import es.taw.gestionbanco.dao.ClienteEntityRepository;
import es.taw.gestionbanco.dao.CuentaBancoRepository;
import es.taw.gestionbanco.entity.ClienteEntity;
import es.taw.gestionbanco.entity.CuentabancoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CajeroController {
    @Autowired
    ClienteEntityRepository clienteEntityRepository;
    @Autowired
    CuentaBancoRepository cuentaBancoRepository;

    @GetMapping("/")
    public String muestraSesion(Model model){
        ClienteEntity cliente = clienteEntityRepository.findById(1).orElse(null);
        return "muestraSesion";
    }
    @PostMapping("/parametrosCuenta")
    public String listaParametrosCuenta(@RequestParam("idCliente") int idCliente, Model model){
        CuentabancoEntity cuentabancoCliente = cuentaBancoRepository.parametrosCliente(idCliente);
        model.addAttribute(cuentabancoCliente);
        return "redirect:/";
    }
    @PutMapping ("/")
    public String modificaDatos(@ModelAttribute("cliente") ClienteEntity cliente){
      return "redirect:/";
    }
}
