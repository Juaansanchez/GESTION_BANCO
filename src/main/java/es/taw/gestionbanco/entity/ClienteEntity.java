package es.taw.gestionbanco.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "cliente", schema = "gestion_banco", catalog = "")
public class ClienteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "numeroIdentificacion", nullable = false, length = 255)
    private String numeroIdentificacion;
    @Basic
    @Column(name = "estado", nullable = false, length = 255)
    private String estado;
    @Basic
    @Column(name = "fechaInicio", nullable = false)
    private Date fechaInicio;
    @OneToMany(mappedBy = "clienteByIdCliente")
    private Collection<BeneficiarioEntity> beneficiariosById;
    @OneToMany(mappedBy = "clienteByIdCliente")
    private Collection<ChatEntity> chatsById;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private PersonaEntity personaById;
    @OneToMany(mappedBy = "clienteByIdCliente")
    private Collection<CuentabancoEntity> cuentabancosById;
    @OneToMany(mappedBy = "clienteByIdCliente")
    private Collection<DireccionEntity> direccionsById;
    @OneToOne(mappedBy = "clienteById")
    private EmpresaEntity empresaById;
    @OneToMany(mappedBy = "clienteByEmisor")
    private Collection<MensajeEntity> mensajesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteEntity that = (ClienteEntity) o;
        return id == that.id && Objects.equals(numeroIdentificacion, that.numeroIdentificacion) && Objects.equals(estado, that.estado) && Objects.equals(fechaInicio, that.fechaInicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroIdentificacion, estado, fechaInicio);
    }

    public Collection<BeneficiarioEntity> getBeneficiariosById() {
        return beneficiariosById;
    }

    public void setBeneficiariosById(Collection<BeneficiarioEntity> beneficiariosById) {
        this.beneficiariosById = beneficiariosById;
    }

    public Collection<ChatEntity> getChatsById() {
        return chatsById;
    }

    public void setChatsById(Collection<ChatEntity> chatsById) {
        this.chatsById = chatsById;
    }

    public PersonaEntity getPersonaById() {
        return personaById;
    }

    public void setPersonaById(PersonaEntity personaById) {
        this.personaById = personaById;
    }

    public Collection<CuentabancoEntity> getCuentabancosById() {
        return cuentabancosById;
    }

    public void setCuentabancosById(Collection<CuentabancoEntity> cuentabancosById) {
        this.cuentabancosById = cuentabancosById;
    }

    public Collection<DireccionEntity> getDireccionsById() {
        return direccionsById;
    }

    public void setDireccionsById(Collection<DireccionEntity> direccionsById) {
        this.direccionsById = direccionsById;
    }

    public EmpresaEntity getEmpresaById() {
        return empresaById;
    }

    public void setEmpresaById(EmpresaEntity empresaById) {
        this.empresaById = empresaById;
    }

    public Collection<MensajeEntity> getMensajesById() {
        return mensajesById;
    }

    public void setMensajesById(Collection<MensajeEntity> mensajesById) {
        this.mensajesById = mensajesById;
    }
}
