package es.taw.gestionbanco.validators;

import es.taw.gestionbanco.entity.DireccionEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class DireccionEntityValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return DireccionEntity.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "calle", "field.required", "El campo calle es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numero", "field.required", "El campo número es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "plantaPuertaOficina", "field.required", "El campo Planta/Puerta/Oficina es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ciudad", "field.required", "El campo ciudad es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pais", "field.required", "El campo pais es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codigoPostal", "field.required", "El campo CP es obligatorio");
    }
}
