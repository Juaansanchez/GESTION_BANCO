// Autor: Ángel Joaquín Rodríguez Rodríguez

package es.taw.gestionbanco.ui;

public class FiltroChat {
    private Integer idCliente;
    private Integer estadoChat;
    private Integer idAsistente;

    public FiltroChat() {
        idCliente = estadoChat = idAsistente = null;
    }
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getEstadoChat() {
        return estadoChat;
    }

    public void setEstadoChat(Integer estadoChat) {
        this.estadoChat = estadoChat;
    }

    public Integer getIdAsistente() {
        return idAsistente;
    }

    public void setIdAsistente(Integer idAsistente) {
        this.idAsistente = idAsistente;
    }
}
