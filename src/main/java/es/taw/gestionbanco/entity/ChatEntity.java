package es.taw.gestionbanco.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "chat", schema = "gestion_banco", catalog = "")
public class ChatEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idChat", nullable = false)
    private int idChat;
    @Basic
    @Column(name = "estado", nullable = false)
    private byte estado;
    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "id", nullable = false)
    private ClienteEntity clienteByIdCliente;
    @ManyToOne
    @JoinColumn(name = "idEmpleado", referencedColumnName = "idAsistente", nullable = false)
    private AsistenteEntity asistenteByIdEmpleado;
    @OneToMany(mappedBy = "chatByChat")
    private Collection<MensajeEntity> mensajesByIdChat;

    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatEntity that = (ChatEntity) o;
        return idChat == that.idChat && estado == that.estado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idChat, estado);
    }

    public ClienteEntity getClienteByIdCliente() {
        return clienteByIdCliente;
    }

    public void setClienteByIdCliente(ClienteEntity clienteByIdCliente) {
        this.clienteByIdCliente = clienteByIdCliente;
    }

    public AsistenteEntity getAsistenteByIdEmpleado() {
        return asistenteByIdEmpleado;
    }

    public void setAsistenteByIdEmpleado(AsistenteEntity asistenteByIdEmpleado) {
        this.asistenteByIdEmpleado = asistenteByIdEmpleado;
    }

    public Collection<MensajeEntity> getMensajesByIdChat() {
        return mensajesByIdChat;
    }

    public void setMensajesByIdChat(Collection<MensajeEntity> mensajesByIdChat) {
        this.mensajesByIdChat = mensajesByIdChat;
    }
}
