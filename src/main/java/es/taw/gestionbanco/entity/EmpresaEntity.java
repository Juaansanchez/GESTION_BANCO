package es.taw.gestionbanco.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "empresa", schema = "gestion_banco", catalog = "")
public class EmpresaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Basic
    @Column(name = "fechaCierre", nullable = false)
    private Date fechaCierre;
    @OneToMany(mappedBy = "empresaByIdEmpresa")
    private Collection<AsistenteEntity> asistentesById;
    @OneToMany(mappedBy = "empresaByIdEmpresa")
    private Collection<AutorizadoEntity> autorizadosById;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private ClienteEntity clienteById;
    @OneToMany(mappedBy = "empresaByIdEmpresa")
    private Collection<SocioEntity> sociosById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpresaEntity that = (EmpresaEntity) o;
        return id == that.id && Objects.equals(nombre, that.nombre) && Objects.equals(fechaCierre, that.fechaCierre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, fechaCierre);
    }

    public Collection<AsistenteEntity> getAsistentesById() {
        return asistentesById;
    }

    public void setAsistentesById(Collection<AsistenteEntity> asistentesById) {
        this.asistentesById = asistentesById;
    }

    public Collection<AutorizadoEntity> getAutorizadosById() {
        return autorizadosById;
    }

    public void setAutorizadosById(Collection<AutorizadoEntity> autorizadosById) {
        this.autorizadosById = autorizadosById;
    }

    public ClienteEntity getClienteById() {
        return clienteById;
    }

    public void setClienteById(ClienteEntity clienteById) {
        this.clienteById = clienteById;
    }

    public Collection<SocioEntity> getSociosById() {
        return sociosById;
    }

    public void setSociosById(Collection<SocioEntity> sociosById) {
        this.sociosById = sociosById;
    }
}
