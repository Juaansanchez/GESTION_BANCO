package es.taw.gestionbanco.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "mensaje", schema = "gestion_banco", catalog = "")
public class MensajeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idMensaje", nullable = false)
    private Integer idMensaje;
    @Basic
    @Column(name = "emisorEsAsistente", nullable = false)
    private Byte emisorEsAsistente;
    @Basic
    @Column(name = "texto", nullable = true, length = 255)
    private String texto;
    @Basic
    @Column(name = "fecha_envio", nullable = true)
    private Timestamp fechaEnvio;
    @ManyToOne
    @JoinColumn(name = "chat", referencedColumnName = "idChat", nullable = false)
    private ChatEntity chatByChat;

    public Integer getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public Byte getEmisorEsAsistente() {
        return emisorEsAsistente;
    }

    public void setEmisorEsAsistente(Byte emisorEsAsistente) {
        this.emisorEsAsistente = emisorEsAsistente;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Timestamp getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Timestamp fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MensajeEntity that = (MensajeEntity) o;
        return Objects.equals(idMensaje, that.idMensaje) && Objects.equals(emisorEsAsistente, that.emisorEsAsistente) && Objects.equals(texto, that.texto) && Objects.equals(fechaEnvio, that.fechaEnvio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMensaje, emisorEsAsistente, texto, fechaEnvio);
    }

    public ChatEntity getChatByChat() {
        return chatByChat;
    }

    public void setChatByChat(ChatEntity chatByChat) {
        this.chatByChat = chatByChat;
    }
}
