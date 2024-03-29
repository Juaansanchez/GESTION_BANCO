package es.taw.gestionbanco.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tipoestadoautorizado", schema = "gestion_banco", catalog = "")
public class TipoestadoautorizadoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "estadoAutorizado", nullable = false, length = 255)
    private String estadoAutorizado;
    @OneToMany(mappedBy = "tipoestadoautorizadoByEstadoAutorizado")
    private List<AutorizadoEntity> autorizadosById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstadoAutorizado() {
        return estadoAutorizado;
    }

    public void setEstadoAutorizado(String estadoAutorizado) {
        this.estadoAutorizado = estadoAutorizado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoestadoautorizadoEntity that = (TipoestadoautorizadoEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(estadoAutorizado, that.estadoAutorizado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, estadoAutorizado);
    }

    public List<AutorizadoEntity> getAutorizadosById() {
        return autorizadosById;
    }

    public void setAutorizadosById(List<AutorizadoEntity> autorizadosById) {
        this.autorizadosById = autorizadosById;
    }
}
