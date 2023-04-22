package es.taw.gestionbanco.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "mensaje", schema = "gestion_banco", catalog = "")
public class MensajeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idMensaje", nullable = false)
    private Integer idMensaje;
    @Basic
    @Column(name = "texto", nullable = true, length = 255)
    private String texto;
    @Basic
    @Column(name = "fecha_envio", nullable = true)
    private Date fechaEnvio;
    @ManyToOne
    @JoinColumn(name = "chat", referencedColumnName = "idChat", nullable = false)
    private ChatEntity chatByChat;
    @ManyToOne
    @JoinColumn(name = "emisor", referencedColumnName = "id", nullable = false)
    private ClienteEntity clienteByEmisor;

    public Integer getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MensajeEntity that = (MensajeEntity) o;
        return Objects.equals(idMensaje, that.idMensaje) && Objects.equals(texto, that.texto) && Objects.equals(fechaEnvio, that.fechaEnvio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMensaje, texto, fechaEnvio);
    }

    public ChatEntity getChatByChat() {
        return chatByChat;
    }

    public void setChatByChat(ChatEntity chatByChat) {
        this.chatByChat = chatByChat;
    }

    public ClienteEntity getClienteByEmisor() {
        return clienteByEmisor;
    }

    public void setClienteByEmisor(ClienteEntity clienteByEmisor) {
        this.clienteByEmisor = clienteByEmisor;
    }
}
