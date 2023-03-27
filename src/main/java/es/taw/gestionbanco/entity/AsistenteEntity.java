package es.taw.gestionbanco.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "asistente", schema = "gestion_banco", catalog = "")
public class AsistenteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idAsistente", nullable = false)
    private int idAsistente;
    @ManyToOne
    @JoinColumn(name = "idEmpresa", referencedColumnName = "id", nullable = false)
    private EmpresaEntity empresaByIdEmpresa;
    @OneToMany(mappedBy = "asistenteByIdEmpleado")
    private Collection<ChatEntity> chatsByIdAsistente;

    public int getIdAsistente() {
        return idAsistente;
    }

    public void setIdAsistente(int idAsistente) {
        this.idAsistente = idAsistente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsistenteEntity that = (AsistenteEntity) o;
        return idAsistente == that.idAsistente;
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

    public Collection<ChatEntity> getChatsByIdAsistente() {
        return chatsByIdAsistente;
    }

    public void setChatsByIdAsistente(Collection<ChatEntity> chatsByIdAsistente) {
        this.chatsByIdAsistente = chatsByIdAsistente;
    }
}
