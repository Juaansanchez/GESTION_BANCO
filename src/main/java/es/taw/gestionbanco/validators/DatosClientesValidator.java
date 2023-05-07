package es.taw.gestionbanco.validators;

import es.taw.gestionbanco.auxiliar.DatosClientes;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class DatosClientesValidator implements Validator {
    private final Validator personaValidator;
    private final Validator direccionValidator;

    public DatosClientesValidator(Validator personaValidator, Validator direccionValidator) {
        this.personaValidator = personaValidator;
        this.direccionValidator = direccionValidator;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return DatosClientes.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        DatosClientes datosClientes = (DatosClientes) target;

        // Validamos la propiedad "persona" utilizando el validador correspondiente
        errors.pushNestedPath("persona");
        ValidationUtils.invokeValidator(personaValidator, datosClientes.getPersona(), errors);
        errors.popNestedPath();

        // Validamos la propiedad "direccion" utilizando el validador correspondiente
        errors.pushNestedPath("direccion");
        ValidationUtils.invokeValidator(direccionValidator, datosClientes.getDireccion(), errors);
        errors.popNestedPath();

        // Validamos los demás campos de DatosClientes
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pass", "field.required", "El campo contraseña es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "repetirPass", "field.required", "Debe repetir la contraseña");

        // Verificar que los campos de contraseña sean iguales
        if (datosClientes.getPass() != null && datosClientes.getRepetirPass() != null)
        {
            if(!datosClientes.getPass().equals(datosClientes.getRepetirPass())) {
                errors.rejectValue("repetirPass", "password.mismatch", "Las contraseñas no coinciden");
            }
        }
    }

}
