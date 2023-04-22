package es.taw.gestionbanco.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tipoestadocuenta", schema = "gestion_banco", catalog = "")
public class TipoestadocuentaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "estadoCuenta", nullable = false, length = 255)
    private String estadoCuenta;
    @OneToMany(mappedBy = "tipoestadocuentaByEstadoCuenta")
    private List<CuentabancoEntity> cuentabancosById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoestadocuentaEntity that = (TipoestadocuentaEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(estadoCuenta, that.estadoCuenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, estadoCuenta);
    }

    public List<CuentabancoEntity> getCuentabancosById() {
        return cuentabancosById;
    }

    public void setCuentabancosById(List<CuentabancoEntity> cuentabancosById) {
        this.cuentabancosById = cuentabancosById;
    }
}
