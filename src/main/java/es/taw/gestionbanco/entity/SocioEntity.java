package es.taw.gestionbanco.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "socio", schema = "gestion_banco", catalog = "")
public class SocioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    private PersonaEntity personaById;
    @ManyToOne
    @JoinColumn(name = "idEmpresa", referencedColumnName = "id", nullable = false)
    private EmpresaEntity empresaByIdEmpresa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocioEntity that = (SocioEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public PersonaEntity getPersonaById() {
        return personaById;
    }

    public void setPersonaById(PersonaEntity personaById) {
        this.personaById = personaById;
    }

    public EmpresaEntity getEmpresaByIdEmpresa() {
        return empresaByIdEmpresa;
    }

    public void setEmpresaByIdEmpresa(EmpresaEntity empresaByIdEmpresa) {
        this.empresaByIdEmpresa = empresaByIdEmpresa;
    }
}
