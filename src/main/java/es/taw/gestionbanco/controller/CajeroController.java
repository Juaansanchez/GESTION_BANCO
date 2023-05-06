package es.taw.gestionbanco.controller;

import es.taw.gestionbanco.dao.ClienteEntityRepository;
import es.taw.gestionbanco.dao.CuentaBancoRepository;
import es.taw.gestionbanco.dao.PersonaEntityRepository;
import es.taw.gestionbanco.entity.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;


@Controller
@RequestMapping("/cajero")
public class CajeroController {
    @Autowired
    ClienteEntityRepository clienteEntityRepository;
    @Autowired
    CuentaBancoRepository cuentaBancoRepository;
    @Autowired
    PersonaEntityRepository personaEntityRepository;

    @GetMapping("")
    public String muestraSesion(@RequestParam("id") int idCliente, Model model){

        ClienteEntity cliente = clienteEntityRepository.findById(idCliente).orElse(null);
        model.addAttribute("cliente",cliente);

        return "cajero";
    }
    @GetMapping("/perfil")
    public String perfilCliente(@RequestParam("id") int idCliente, Model model){

        ClienteEntity cliente = clienteEntityRepository.findById(idCliente).orElse(null);
        model.addAttribute("cliente", cliente);

        return "perfilCajeroCliente";
    }
    @GetMapping ("/operaciones")
    public String operacionesCliente(@RequestParam("id") int idCliente, Model model){

      return "operacionesCajeroCliente";
    }

    @PostMapping("/guardarCambiosCliente")
    public String modificaCambiosCliente(@RequestParam("id") int id, @RequestParam("nombre") String nombre,
                                         @RequestParam("apellido")String apellido, @RequestParam("segundoApellido") String segundoApellido,
                                         @RequestParam("fechaNacimiento") Date fechaNacimiento){
        this.personaEntityRepository.actualizaCliente(id,nombre,apellido,segundoApellido,fechaNacimiento);
        return "redirect:/cajero/perfil?id="+id;
    }
}
