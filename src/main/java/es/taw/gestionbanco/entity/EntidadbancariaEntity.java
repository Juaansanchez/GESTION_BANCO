package es.taw.gestionbanco.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "entidadbancaria", schema = "gestion_banco", catalog = "")
public class EntidadbancariaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @OneToMany(mappedBy = "entidadbancariaByEntidadBancaria")
    private List<CuentabancoEntity> cuentabancosById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntidadbancariaEntity that = (EntidadbancariaEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    public List<CuentabancoEntity> getCuentabancosById() {
        return cuentabancosById;
    }

    public void setCuentabancosById(List<CuentabancoEntity> cuentabancosById) {
        this.cuentabancosById = cuentabancosById;
    }
}
