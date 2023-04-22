package es.taw.gestionbanco.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "transaccion", schema = "gestion_banco", catalog = "")
public class TransaccionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "fechaInstruccion", nullable = false)
    private Date fechaInstruccion;
    @Basic
    @Column(name = "fechaEjecucion", nullable = false)
    private Date fechaEjecucion;
    @OneToOne(mappedBy = "transaccionByIdTransaccion")
    private CambiodivisaEntity cambiodivisaById;
    @OneToMany(mappedBy = "transaccionByIdTransaccion")
    private List<PagoEntity> pagosById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInstruccion() {
        return fechaInstruccion;
    }

    public void setFechaInstruccion(Date fechaInstruccion) {
        this.fechaInstruccion = fechaInstruccion;
    }

    public Date getFechaEjecucion() {
        return fechaEjecucion;
    }

    public void setFechaEjecucion(Date fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransaccionEntity that = (TransaccionEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(fechaInstruccion, that.fechaInstruccion) && Objects.equals(fechaEjecucion, that.fechaEjecucion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechaInstruccion, fechaEjecucion);
    }

    public CambiodivisaEntity getCambiodivisaById() {
        return cambiodivisaById;
    }

    public void setCambiodivisaById(CambiodivisaEntity cambiodivisaById) {
        this.cambiodivisaById = cambiodivisaById;
    }

    public List<PagoEntity> getPagosById() {
        return pagosById;
    }

    public void setPagosById(List<PagoEntity> pagosById) {
        this.pagosById = pagosById;
    }
}
