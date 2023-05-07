package es.taw.gestionbanco.controller;

import es.taw.gestionbanco.auxiliar.DatosClientes;
import es.taw.gestionbanco.dao.PersonaEntityRepository;
import es.taw.gestionbanco.entity.DireccionEntity;
import es.taw.gestionbanco.entity.PersonaEntity;
import es.taw.gestionbanco.service.ModificarDatosClienteService;
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

@Controller
@RequestMapping("/modificarCliente")
public class ModificarDatosClienteController {

    private DatosClientes datosClientes;
    @Autowired
    private PersonaEntityRepository personaEntityRepository;
    @Autowired
    private ModificarDatosClienteService modificarDatosClienteService;

    @GetMapping("/")
    public String initializeDatosCliente(@ModelAttribute("datosClientes") DatosClientes datosClientes, Model model) {
        //System.out.println("HE LLEGADO A ESTE METODO");

        if(datosClientes == null)
        {
            System.out.println("NO SE PUDO RECUPERAR DATOS DE CUENTA");
            datosClientes = new DatosClientes();
            datosClientes.setPersona(new PersonaEntity());
            datosClientes.setDireccion(new DireccionEntity());
        }
        model.addAttribute("datosClientes", datosClientes);
        System.out.println("DATOS DE LA PERSONA: " + datosClientes.toString());
        return "/modificarDatosCliente";
    }

    @PostMapping("/modificarDatos")
    public String modificarDatos(@ModelAttribute("datosClientes") DatosClientes datosClientes, Model model, BindingResult result) {
        String urlTo;

        if(datosClientes == null){
            this.datosClientes = datosClientes;
            return "PantallaErrorDatos";
        }
        DatosClientesValidator validator = new DatosClientesValidator(new PersonaEntityValidator(), new DireccionEntityValidator());
        validator.validate(datosClientes, result);

        if(result.hasErrors()){
            //System.out.println("ERRORES: " + result.toString());
            model.addAttribute("erroresDatos", result.getAllErrors());
            return "PantallaErrorDatos";
        }
        else{
            System.out.println("DATOS A METER: " + datosClientes.toString());
            urlTo = modificarDatosClienteService.newData(datosClientes);
            System.out.println("URL: " + urlTo);
            if (urlTo.equals("operacionesCliente"))
                this.datosClientes = null;
            else
                this.datosClientes = datosClientes;
            return urlTo;
        }
    }
}
