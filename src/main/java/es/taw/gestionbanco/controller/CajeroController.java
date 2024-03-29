//Autor: Álvaro Alemán Rando
package es.taw.gestionbanco.controller;

import es.taw.gestionbanco.dao.*;
import es.taw.gestionbanco.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/cajero")
public class CajeroController {
    @Autowired
    ClienteEntityRepository clienteEntityRepository;
    @Autowired
    CuentabancoEntityRepository cuentabancoEntityRepository;
    @Autowired
    PersonaEntityRepository personaEntityRepository;
    @Autowired
    BeneficiarioEntityRepository beneficiarioEntityRepository;
    @Autowired
    TransaccionEntityRepository transaccionEntityRepository;
    @Autowired
    PagoEntityRepository pagoEntityRepository;

    @GetMapping("")
    public String muestraSesion(@RequestParam("id") Integer idCliente, Model model) {

        ClienteEntity cliente = clienteEntityRepository.findById(idCliente).orElse(null);
        model.addAttribute("cliente", cliente);

        List<CuentabancoEntity> todasLasCuentas = cuentabancoEntityRepository.findAll();
        List<CuentabancoEntity> cuentas = new ArrayList<>();

        for (CuentabancoEntity c : todasLasCuentas) {
            if (c.getClienteByIdCliente().getId() == idCliente) {
                cuentas.add(c);
            }
        }

        model.addAttribute("cuentas", cuentas);

        return "cajero";
    }

    @GetMapping("/perfil")
    public String perfilCliente(@RequestParam("id") Integer idCliente, Model model) {

        ClienteEntity cliente = clienteEntityRepository.findById(idCliente).orElse(null);
        model.addAttribute("cliente", cliente);

        return "perfilCajeroCliente";
    }

    @GetMapping("/transferencias")
    public String transferenciasCliente(@RequestParam("id") Integer idCliente, Model model) {

        ClienteEntity cliente = clienteEntityRepository.findById(idCliente).orElse(null);
        model.addAttribute("cliente", cliente);

        List<CuentabancoEntity> todasLasCuentas = cuentabancoEntityRepository.findAll();
        List<CuentabancoEntity> cuentasCliente = new ArrayList<>();

        for (CuentabancoEntity c : todasLasCuentas) {
            if (c.getClienteByIdCliente().getId() == idCliente) {
                cuentasCliente.add(c);
            }
        }
        model.addAttribute("cuentasCliente", cuentasCliente);

        return "transferencias";
    }

    @GetMapping("/retiroDinero")
    public String retiradaDineroCliente(@RequestParam("id") Integer idCliente, Model model) {

        ClienteEntity cliente = clienteEntityRepository.findById(idCliente).orElse(null);
        model.addAttribute("cliente", cliente);

        List<CuentabancoEntity> todasLasCuentas = cuentabancoEntityRepository.findAll();
        List<CuentabancoEntity> cuentasCliente = new ArrayList<>();

        for (CuentabancoEntity c : todasLasCuentas) {
            if (c.getClienteByIdCliente().getId() == idCliente) {
                cuentasCliente.add(c);
            }
        }
        model.addAttribute("cuentasCliente", cuentasCliente);
        return "retiroDinero";
    }

    @GetMapping("/cambioDivisa")
    public String cambioDivisaCliente(@RequestParam("id") Integer idCliente, Model model) {

        ClienteEntity cliente = clienteEntityRepository.findById(idCliente).orElse(null);
        model.addAttribute("cliente", cliente);

        List<CuentabancoEntity> todasLasCuentas = cuentabancoEntityRepository.findAll();
        List<CuentabancoEntity> cuentasCliente = new ArrayList<>();

        for (CuentabancoEntity c : todasLasCuentas) {
            if (c.getClienteByIdCliente().getId() == idCliente) {
                cuentasCliente.add(c);
            }
        }
        model.addAttribute("cuentasCliente", cuentasCliente);
        return "cambioDivisa";
    }

    @GetMapping("/operaciones")
    public String operacionesCliente(@RequestParam("id") Integer idCliente, Model model) {

        ClienteEntity cliente = clienteEntityRepository.findById(idCliente).orElse(null);
        model.addAttribute("cliente", cliente);

        return "operacionesCajeroCliente";
    }

    @GetMapping("/registroOperaciones")
    public String registroOperaciones(@RequestParam("id") Integer idCliente, Model model) {

        ClienteEntity cliente = clienteEntityRepository.findById(idCliente).orElse(null);
        model.addAttribute("cliente", cliente);

        BeneficiarioEntity beneficiario = this.beneficiarioEntityRepository.findByIdCliente(idCliente);
        List<PagoEntity> pagos = pagoEntityRepository.pagosPorIdBeneficiario(beneficiario.getIdBeneficiario());

        model.addAttribute("pagos", pagos);


        return "registroOperaciones";
    }

    @PostMapping("/guardarCambiosCliente")
    public String modificaCambiosCliente(@RequestParam("id") Integer id, @RequestParam("dni") String dni,
                                         @RequestParam("nombre") String nombre, @RequestParam("segundoNombre") String segundoNombre,
                                         @RequestParam("apellido") String apellido, @RequestParam("segundoApellido") String segundoApellido,
                                         @RequestParam("fechaNacimiento") Date fechaNacimiento, @RequestParam("reactivacion") String reactivacion) {

        PersonaEntity persona = this.personaEntityRepository.findById(id).orElse(null);
        ClienteEntity cliente = this.clienteEntityRepository.findById(id).orElse(null);

        persona.setNombre(nombre);
        persona.setSegundoNombre(segundoNombre);
        persona.setApellido(apellido);
        persona.setSegundoApellido(segundoApellido);
        persona.setFechaNacimiento(fechaNacimiento);

        if (reactivacion == "si") {
            cliente.setEstado("pendienteDesbloqueo");
        }

        cliente.setPersonaById(persona);

        this.clienteEntityRepository.save(cliente);
        this.personaEntityRepository.save(persona);

        return "redirect:/cajero?id=" + id;
    }

    @PostMapping("/transferirDinero")
    public String transfiereDinero(@RequestParam("id") Integer id, @RequestParam("cuentaBanco") String cuentaBanco,
                                   @RequestParam("importe") Integer importe, @RequestParam("cuentaDestino") String cuentaDestino) {

        List<CuentabancoEntity> todasLasCuentas = cuentabancoEntityRepository.findAll();
        List<CuentabancoEntity> cuentasCliente = new ArrayList<>();
        CuentabancoEntity cuentaBeneficiario = cuentabancoEntityRepository.cuentaPorIBAN(cuentaDestino);

        for (CuentabancoEntity c : todasLasCuentas) {
            if (c.getClienteByIdCliente().getId() == id) {
                cuentasCliente.add(c);
            }
        }

        for (CuentabancoEntity c : cuentasCliente) {
            c.setSaldo(c.getSaldo() - importe);
            this.cuentabancoEntityRepository.save(c);
        }

        System.out.println("----------------------------------");
        cuentaBeneficiario.setSaldo(cuentaBeneficiario.getSaldo() + importe);
        System.out.println(cuentaBeneficiario.getSaldo());
        System.out.println("----------------------------------");
        this.cuentabancoEntityRepository.save(cuentaBeneficiario);


        return "redirect:/cajero?id=" + id;
    }


    @PostMapping("/retirarDinero")
    public String retiraDinero(@RequestParam("id") Integer id, @RequestParam("cuentaBanco") String cuentaBanco,
                               @RequestParam("importe") Integer importe) {

        List<CuentabancoEntity> todasLasCuentas = this.cuentabancoEntityRepository.findAll();
        List<CuentabancoEntity> cuentasCliente = new ArrayList<>();

        for (CuentabancoEntity c : todasLasCuentas) {
            if (c.getClienteByIdCliente().getId() == id) {
                cuentasCliente.add(c);
            }
        }

        for (CuentabancoEntity c : cuentasCliente) {
            c.setSaldo(c.getSaldo() - importe);
            this.cuentabancoEntityRepository.save(c);
        }


        return "redirect:/cajero?id=" + id;
    }

    @PostMapping("/cambioDivisa")
    public String cambioDivisa(@RequestParam("id") Integer id, @RequestParam("cuentaBanco") String cuentaBanco,
                               @RequestParam("importe") Integer importe, @RequestParam("divisa") String divisa, Model model) {

        List<CuentabancoEntity> todasLasCuentas = this.cuentabancoEntityRepository.findAll();
        List<CuentabancoEntity> cuentasCliente = new ArrayList<>();

        for (CuentabancoEntity c : todasLasCuentas) {
            if (c.getClienteByIdCliente().getId() == id) {
                cuentasCliente.add(c);
            }
        }

        if (divisa == "libra") {
            for (CuentabancoEntity c : cuentasCliente) {
                c.setSaldo(c.getSaldo() - importe * 1);
                this.cuentabancoEntityRepository.save(c);
            }
        } else {
            for (CuentabancoEntity c : cuentasCliente) {
                c.setSaldo(c.getSaldo() - importe * 2);
                this.cuentabancoEntityRepository.save(c);
            }
        }

        return "redirect:/cajero?id=" + id;
    }
}
