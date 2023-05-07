package es.taw.gestionbanco.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cliente", schema = "gestion_banco", catalog = "")
public class ClienteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
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
    private List<BeneficiarioEntity> beneficiariosById;
    @OneToMany(mappedBy = "clienteByIdCliente")
    private List<ChatEntity> chatsById;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private PersonaEntity personaById;
    @OneToMany(mappedBy = "clienteByIdCliente")
    private List<CuentabancoEntity> cuentabancosById;
    @OneToMany(mappedBy = "clienteByIdCliente")
    private List<DireccionEntity> direccionsById;
    @OneToOne(mappedBy = "clienteById")
    private EmpresaEntity empresaById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return Objects.equals(id, that.id) && Objects.equals(numeroIdentificacion, that.numeroIdentificacion) && Objects.equals(estado, that.estado) && Objects.equals(fechaInicio, that.fechaInicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroIdentificacion, estado, fechaInicio);
    }

    @Override
    public String toString() {
        return "ClienteEntity{" +
                "id=" + id +
                ", numeroIdentificacion='" + numeroIdentificacion + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", beneficiariosById=" + beneficiariosById +
                ", chatsById=" + chatsById +
                ", personaById=" + personaById +
                ", cuentabancosById=" + cuentabancosById +
                ", direccionsById=" + direccionsById +
                ", empresaById=" + empresaById +
                ", mensajesById=" + mensajesById +
                '}';
    }

    public List<BeneficiarioEntity> getBeneficiariosById() {
        return beneficiariosById;
    }

    public void setBeneficiariosById(List<BeneficiarioEntity> beneficiariosById) {
        this.beneficiariosById = beneficiariosById;
    }

    public List<ChatEntity> getChatsById() {
        return chatsById;
    }

    public void setChatsById(List<ChatEntity> chatsById) {
        this.chatsById = chatsById;
    }

    public PersonaEntity getPersonaById() {
        return personaById;
    }

    public void setPersonaById(PersonaEntity personaById) {
        this.personaById = personaById;
    }

    public List<CuentabancoEntity> getCuentabancosById() {
        return cuentabancosById;
    }

    public void setCuentabancosById(List<CuentabancoEntity> cuentabancosById) {
        this.cuentabancosById = cuentabancosById;
    }

    public List<DireccionEntity> getDireccionsById() {
        return direccionsById;
    }

    public void setDireccionsById(List<DireccionEntity> direccionsById) {
        this.direccionsById = direccionsById;
    }

    public EmpresaEntity getEmpresaById() {
        return empresaById;
    }

    public void setEmpresaById(EmpresaEntity empresaById) {
        this.empresaById = empresaById;
    }
}
