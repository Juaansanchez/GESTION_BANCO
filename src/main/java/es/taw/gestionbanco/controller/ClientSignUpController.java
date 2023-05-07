package es.taw.gestionbanco.controller;

import es.taw.gestionbanco.auxiliar.DatosClientes;
import es.taw.gestionbanco.dao.PersonaEntityRepository;
import es.taw.gestionbanco.entity.DireccionEntity;
import es.taw.gestionbanco.entity.PersonaEntity;
import es.taw.gestionbanco.service.ClientSignUpService;
import es.taw.gestionbanco.validators.DatosClientesValidator;
import es.taw.gestionbanco.validators.DireccionEntityValidator;
import es.taw.gestionbanco.validators.PersonaEntityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/signup")
public class ClientSignUpController {

    @Autowired
    protected ClientSignUpService cliRegService;
    @Autowired
    private PersonaEntityRepository personaEntityRepository;
    private DatosClientes datosClientes;

    @GetMapping("/")
    public String initializeDatosCliente(Model model) {
        //System.out.println("HE LLEGADO A ESTE METODO");

        if (datosClientes == null) {
            datosClientes = new DatosClientes();
            datosClientes.setPersona(new PersonaEntity());
            datosClientes.setDireccion(new DireccionEntity());
        }
        model.addAttribute("datosClientes", datosClientes);
        System.out.println("DATOS PARA EL FORM: " + datosClientes.toString());
        return "/altaCliente";
    }

    /*
        @GetMapping("/limpiar")
        public String limpiarDatosCliente(Model model) {
            datosClientes = null;
            return  "/altaCliente";
        }
    */
    @PostMapping("/procesarRegistro")
    public String doSignUp(@ModelAttribute("datosClientes") DatosClientes datosClientes, Model model, BindingResult result, RedirectAttributes redirectAttributes) {
        String urlTo;
        System.out.println("===================HE SIDO LLAMADO, SOY SIGNUP====================");

        if (datosClientes.getPersona() == null || datosClientes.getDireccion() == null) {
            this.datosClientes = datosClientes;
            return "PantallaErrorRegistro";
        }
        DatosClientesValidator validator = new DatosClientesValidator(new PersonaEntityValidator(), new DireccionEntityValidator());
        validator.validate(datosClientes, result);
        if (result.hasErrors()) {
            //System.out.println("ERRORES: " + result.toString());
            model.addAttribute("errores", result.getAllErrors());
            this.datosClientes = datosClientes;
            return "PantallaErrorRegistro";
        } else {
            System.out.println("PERSONA A REGISRAR: " + datosClientes.toString());
            urlTo = cliRegService.newClient(datosClientes);
            redirectAttributes.addFlashAttribute("exito", "El cliente se ha registrado correctamente.");
            System.out.println("URL: " + urlTo);
            this.datosClientes = datosClientes;
            return urlTo;
        }
    }
}

