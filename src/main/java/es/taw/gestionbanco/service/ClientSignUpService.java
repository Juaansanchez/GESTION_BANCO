package es.taw.gestionbanco.service;

import es.taw.gestionbanco.auxiliar.DatosClientes;
import es.taw.gestionbanco.controller.ClientSignUpController;
import es.taw.gestionbanco.dao.ClienteEntityRepository;
import es.taw.gestionbanco.dao.DireccionEntityRepository;
import es.taw.gestionbanco.dao.PersonaEntityRepository;
import es.taw.gestionbanco.entity.ClienteEntity;
import es.taw.gestionbanco.entity.DireccionEntity;
import es.taw.gestionbanco.entity.PersonaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
@Service
public class ClientSignUpService {

    @Autowired
    private PersonaEntityRepository personaEntityRepository;
    @Autowired
    private ClienteEntityRepository clienteEntityRepository;
    @Autowired
    private DireccionEntityRepository direccionEntityRepository;

    public String newClient(DatosClientes datosClientes){
        System.out.println("HE SIDO LLAMADO PARA REGISTRAR");
        PersonaEntity persona = datosClientes.getPersona();
        ClienteEntity cliente = new ClienteEntity();
        DireccionEntity direccion = datosClientes.getDireccion();

        try {
            personaEntityRepository.save(persona);

            cliente.setNumeroIdentificacion(persona.getDni().toString());
            cliente.setEstado("activa");
            cliente.setFechaInicio(Date.valueOf(LocalDate.now()));
            cliente.setPersonaById(persona);
            System.out.println("Meto cliente con valores"+ cliente.toString());
            clienteEntityRepository.save(cliente);

            if(direccion.getValida() == null){
                direccion.setValida((byte) 0);
                System.out.println("Meto direccion con valor en valida: "+ direccion.getValida());
            }
            direccion.setClienteByIdCliente(cliente);
            direccionEntityRepository.save(direccion);
        } catch (DataIntegrityViolationException e) {
            System.err.println("ERROR AL INTRODUCIR DATOS: " + e.toString());
            clienteEntityRepository.delete(cliente);
            personaEntityRepository.delete(persona);
            direccionEntityRepository.delete(direccion);
            return "PantallaError";
        }
        return "operacionesCliente";
    }
}
