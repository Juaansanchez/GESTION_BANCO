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
import java.util.Optional;

@Service
public class ModificarDatosClienteService {

    @Autowired
    private PersonaEntityRepository personaEntityRepository;
    @Autowired
    private DireccionEntityRepository direccionEntityRepository;

    public String newData(DatosClientes datosClientes){
        System.out.println("HE SIDO LLAMADO PARA MODIFICAR DATOS");
        PersonaEntity persona = personaEntityRepository.findByDni(datosClientes.getPersona().getDni());
        Optional<DireccionEntity> optionalDireccion = direccionEntityRepository.findById(datosClientes.getDireccion().getId());
        DireccionEntity direccion = optionalDireccion.orElse(null);

        try {
            System.out.println("METO NUEVOS DATOS DE PERSONA: "+ persona.toString());
            personaEntityRepository.save(persona);

            if(direccion == null)
                throw new DataIntegrityViolationException("no tiene direccion asignada, no puedo añadir nulo");
            direccionEntityRepository.save(direccion);
        } catch (DataIntegrityViolationException e) {
            System.err.println("ERROR AL INTRODUCIR NUEVOS DATOS: " + e.toString());
            return "PantallaErrorDatos";
        }
        return "operacionesCliente";
    }
}
