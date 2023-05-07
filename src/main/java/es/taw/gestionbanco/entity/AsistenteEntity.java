package es.taw.gestionbanco.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "asistente", schema = "gestion_banco", catalog = "")
public class AsistenteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idAsistente", nullable = false)
    private Integer idAsistente;
    @ManyToOne
    @JoinColumn(name = "idEmpresa", referencedColumnName = "id", nullable = false)
    private EmpresaEntity empresaByIdEmpresa;
    @OneToMany(mappedBy = "asistenteByIdEmpleado")
    private List<ChatEntity> chatsByIdAsistente;

    public Integer getIdAsistente() {
        return idAsistente;
    }

    public void setIdAsistente(Integer idAsistente) {
        this.idAsistente = idAsistente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsistenteEntity asistente = (AsistenteEntity) o;
        return Objects.equals(idAsistente, asistente.idAsistente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAsistente);
    }

    public EmpresaEntity getEmpresaByIdEmpresa() {
        return empresaByIdEmpresa;
    }

    public void setEmpresaByIdEmpresa(EmpresaEntity empresaByIdEmpresa) {
        this.empresaByIdEmpresa = empresaByIdEmpresa;
    }

    public List<ChatEntity> getChatsByIdAsistente() {
        return chatsByIdAsistente;
    }

    public void setChatsByIdAsistente(List<ChatEntity> chatsByIdAsistente) {
        this.chatsByIdAsistente = chatsByIdAsistente;
    }
}
