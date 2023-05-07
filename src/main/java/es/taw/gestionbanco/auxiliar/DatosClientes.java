package es.taw.gestionbanco.auxiliar;

import es.taw.gestionbanco.entity.DireccionEntity;
import es.taw.gestionbanco.entity.PersonaEntity;
public class DatosClientes{
    protected PersonaEntity persona;
    protected DireccionEntity direccion;
    protected String pass;
    protected String repetirPass;

    public void setPersona(PersonaEntity personaEntity) { persona = personaEntity; }

    public PersonaEntity getPersona() { return persona; }

    public void setDireccion(DireccionEntity direccionEntity) { direccion = direccionEntity; }
    public DireccionEntity getDireccion() { return direccion; }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRepetirPass() {
        return repetirPass;
    }

    public void setRepetirPass(String repetirPass) {
        this.repetirPass = repetirPass;
    }

    @Override
    public String toString(){
        String p, d;
        if(persona == null)
            p = "(nulo)";
        else
            p = persona.toString();
        if(direccion == null)
            d = "(nulo)";
        else
            d = direccion.toString();
        return "Persona: " + p + ", direccion: " + d + ", contraseña y repetida: " + pass + ", " + repetirPass;
    }
}
