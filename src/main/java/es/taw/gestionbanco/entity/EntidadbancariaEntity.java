package es.taw.gestionbanco.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "entidadbancaria", schema = "gestion_banco", catalog = "")
public class EntidadbancariaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @OneToMany(mappedBy = "entidadbancariaByEntidadBancaria")
    private Collection<CuentabancoEntity> cuentabancosById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntidadbancariaEntity that = (EntidadbancariaEntity) o;
        return id == that.id && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    public Collection<CuentabancoEntity> getCuentabancosById() {
        return cuentabancosById;
    }

    public void setCuentabancosById(Collection<CuentabancoEntity> cuentabancosById) {
        this.cuentabancosById = cuentabancosById;
    }
}
