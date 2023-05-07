<%-- Autor: Ángel Joaquín Rodríguez Rodríguez --%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page import="es.taw.gestionbanco.entity.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ChatEntity chat = (ChatEntity) request.getAttribute("chatActual");
    boolean esAsistente = ((MensajeEntity) request.getAttribute("mensajeNuevo")).getEmisorEsAsistente() == 1;
    List<MensajeEntity> mensajes = chat.getMensajesByIdChat();

    PersonaEntity personaCliente = chat.getClienteByIdCliente().getPersonaById();
    String segundoNombre = personaCliente.getSegundoNombre();
    String segundoApellido = personaCliente.getSegundoApellido();
    String nombre = (segundoNombre == null)?
            personaCliente.getNombre() : personaCliente.getNombre() + " " + segundoNombre;
    String apellidos = (segundoApellido == null)?
            personaCliente.getApellido() : personaCliente.getApellido() + " " + segundoApellido;
    String nombreCliente = apellidos + ", " + nombre;

    String nombreAsistente = "Asistente " + chat.getAsistenteByIdEmpleado().getIdAsistente();

    String titulo = (!esAsistente)?
            "Chat de " + nombreCliente :
            "Chat de " + nombreAsistente;
%>

<html>
<head>
    <title><%= titulo %></title>
</head>
<body>
<h1><%= titulo %></h1>
<table border="1" width="40%" style="margin-left: auto; margin-right: auto;">
    <tr>
        <th>HISTORIAL DE MENSAJES</th>
    </tr>
    <tr>
        <td>
            <%
                if (mensajes.isEmpty()) {
            %>
            No hay mensajes.
            <%
                } else {
            %>
            <table>
                <%
                    for (MensajeEntity mensaje : mensajes) {
                        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss",
                                Locale.forLanguageTag("es-ES"));
                        String fechaString = fmt.format(mensaje.getFechaEnvio());
                        String nombreEmisor;

                        if (mensaje.getEmisorEsAsistente() == 0) {
                            nombreEmisor = nombreCliente;
                        } else {
                            nombreEmisor = nombreAsistente;
                        }
                %>
                <tr>
                    <td>
                        <%
                            if (mensaje.getEmisorEsAsistente() == 1) {
                        %>
                        <div style="color: blue;font-weight: bold;">
                        <%
                            } else {
                        %>
                        <div style="color: red;font-weight: bold;">
                        <%
                            }
                        %>
                            <%= nombreEmisor %> [<%= fechaString %>]:
                        </div><%= mensaje.getTexto() %>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
            <%
                }
            %>
        </td>
    </tr>
</table>
<%
    if (chat.getEstado() == 1) {
%>
<table style="margin-left: auto; margin-right: auto;">
    <tr>
        <td>
            <form:form method="POST" action="/chat/enviarMensaje" modelAttribute="mensajeNuevo">
                <form:hidden path="idMensaje"/>
                <form:hidden path="emisorEsAsistente"/>
                <form:hidden path="chatByChat"/>
                <form:textarea path="texto" rows="4" cols="64" maxlength="255"/><br/>
                <form:button>Enviar</form:button>
            </form:form>
        </td>
    </tr>
</table>
<%
    }

    if (esAsistente) {
%>
<a href="/asistente/chats?id=<%= chat.getAsistenteByIdEmpleado().getIdAsistente() %>">Volver atrás</a>
<%
    } else {
%>
<a href="/cliente/chats?id=<%= chat.getClienteByIdCliente().getId() %>">Volver atrás</a>
<%
    }
%>
</body>
</html>
