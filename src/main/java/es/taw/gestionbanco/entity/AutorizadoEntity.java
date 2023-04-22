package es.taw.gestionbanco.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "autorizado", schema = "gestion_banco", catalog = "")
public class AutorizadoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "fechaFin", nullable = true)
    private Date fechaFin;
    @Basic
    @Column(name = "dni", nullable = false, length = 255)
    private String dni;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private PersonaEntity personaById;
    @ManyToOne
    @JoinColumn(name = "idCuentaBanco", referencedColumnName = "id", nullable = false)
    private CuentabancoEntity cuentabancoByIdCuentaBanco;
    @ManyToOne
    @JoinColumn(name = "idEmpresa", referencedColumnName = "id", nullable = false)
    private EmpresaEntity empresaByIdEmpresa;
    @ManyToOne
    @JoinColumn(name = "estadoAutorizado", referencedColumnName = "id", nullable = false)
    private TipoestadoautorizadoEntity tipoestadoautorizadoByEstadoAutorizado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutorizadoEntity that = (AutorizadoEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(fechaFin, that.fechaFin) && Objects.equals(dni, that.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechaFin, dni);
    }

    public PersonaEntity getPersonaById() {
        return personaById;
    }

    public void setPersonaById(PersonaEntity personaById) {
        this.personaById = personaById;
    }

    public CuentabancoEntity getCuentabancoByIdCuentaBanco() {
        return cuentabancoByIdCuentaBanco;
    }

    public void setCuentabancoByIdCuentaBanco(CuentabancoEntity cuentabancoByIdCuentaBanco) {
        this.cuentabancoByIdCuentaBanco = cuentabancoByIdCuentaBanco;
    }

    public EmpresaEntity getEmpresaByIdEmpresa() {
        return empresaByIdEmpresa;
    }

    public void setEmpresaByIdEmpresa(EmpresaEntity empresaByIdEmpresa) {
        this.empresaByIdEmpresa = empresaByIdEmpresa;
    }

    public TipoestadoautorizadoEntity getTipoestadoautorizadoByEstadoAutorizado() {
        return tipoestadoautorizadoByEstadoAutorizado;
    }

    public void setTipoestadoautorizadoByEstadoAutorizado(TipoestadoautorizadoEntity tipoestadoautorizadoByEstadoAutorizado) {
        this.tipoestadoautorizadoByEstadoAutorizado = tipoestadoautorizadoByEstadoAutorizado;
    }
}
