package es.taw.gestionbanco.validators;

import es.taw.gestionbanco.dao.PersonaEntityRepository;
import es.taw.gestionbanco.entity.PersonaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonaEntityValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PersonaEntity.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "field.required", "El campo dni es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "field.required", "El campo primer nombre es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellido", "field.required", "El campo primer apellido es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fechaNacimiento", "field.required", "El campo fecha nacimiento es obligatorio");
    }
}
