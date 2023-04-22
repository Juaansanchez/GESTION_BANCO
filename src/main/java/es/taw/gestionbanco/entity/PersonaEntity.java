package es.taw.gestionbanco.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "persona", schema = "gestion_banco", catalog = "")
public class PersonaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "dni", nullable = false, length = 255)
    private String dni;
    @Basic
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Basic
    @Column(name = "segundoNombre", nullable = true, length = 255)
    private String segundoNombre;
    @Basic
    @Column(name = "apellido", nullable = false, length = 255)
    private String apellido;
    @Basic
    @Column(name = "segundoApellido", nullable = true, length = 255)
    private String segundoApellido;
    @Basic
    @Column(name = "fechaNacimiento", nullable = false)
    private Date fechaNacimiento;
    @OneToOne(mappedBy = "personaById")
    private AutorizadoEntity autorizadoById;
    @OneToOne(mappedBy = "personaById")
    private ClienteEntity clienteById;
    @OneToOne(mappedBy = "personaById")
    private SocioEntity socioById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonaEntity that = (PersonaEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(dni, that.dni) && Objects.equals(nombre, that.nombre) && Objects.equals(segundoNombre, that.segundoNombre) && Objects.equals(apellido, that.apellido) && Objects.equals(segundoApellido, that.segundoApellido) && Objects.equals(fechaNacimiento, that.fechaNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dni, nombre, segundoNombre, apellido, segundoApellido, fechaNacimiento);
    }

    public AutorizadoEntity getAutorizadoById() {
        return autorizadoById;
    }

    public void setAutorizadoById(AutorizadoEntity autorizadoById) {
        this.autorizadoById = autorizadoById;
    }

    public ClienteEntity getClienteById() {
        return clienteById;
    }

    public void setClienteById(ClienteEntity clienteById) {
        this.clienteById = clienteById;
    }

    public SocioEntity getSocioById() {
        return socioById;
    }

    public void setSocioById(SocioEntity socioById) {
        this.socioById = socioById;
    }
}
