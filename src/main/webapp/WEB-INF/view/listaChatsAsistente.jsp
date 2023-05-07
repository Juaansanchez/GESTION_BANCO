<%-- Autor: Ángel Joaquín Rodríguez Rodríguez --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List" %>
<%@ page import="es.taw.gestionbanco.entity.ChatEntity" %>
<%@ page import="es.taw.gestionbanco.entity.PersonaEntity" %>
<%@ page import="es.taw.gestionbanco.entity.AsistenteEntity" %>
<%@ page import="es.taw.gestionbanco.entity.ClienteEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<ChatEntity> chats = (List<ChatEntity>) request.getAttribute("listaChatsAsistente");
    AsistenteEntity asistente = (AsistenteEntity) request.getAttribute("asistente");
    List<ClienteEntity> clientesAsistente = (List<ClienteEntity>) request.getAttribute("clientesAsistente");
%>

<html>
<head>
    <title>Test</title>
</head>
<body>
<h1>Listado de chats del asistente <%= asistente.getIdAsistente() %></h1>
<form:form method="POST" action="/asistente/filtrar" modelAttribute="filtro">
    Cliente: <form:select path="idCliente">
        <form:option value="" label=""/>
    <c:forEach var="cliente" items="${clientesAsistente}">
        <form:option value="${cliente.id}">
            ${cliente.personaById.apellido} ${cliente.personaById.segundoApellido}, ${cliente.personaById.nombre} ${cliente.personaById.segundoNombre}
        </form:option>
    </c:forEach>
    </form:select>
    <form:radiobutton path="estadoChat" value="-1" label="Todos"/>
    <form:radiobutton path="estadoChat" value="1" label="Abiertos"/>
    <form:radiobutton path="estadoChat" value="0" label="Cerrados"/>
    <form:hidden path="idAsistente"/>
    <form:button>Filtrar</form:button>
</form:form>
<table border="1">
    <tr>
        <th>ID</th>
        <th>CLIENTE</th>
        <th>ESTADO</th>
        <th></th>
    </tr>
    <%
        for (ChatEntity chat : chats) {
            PersonaEntity personaCliente = chat.getClienteByIdCliente().getPersonaById();
            String nombre = (personaCliente.getSegundoNombre() == null)? personaCliente.getNombre() : personaCliente.getNombre() + " " + personaCliente.getSegundoNombre();
            String apellidos = (personaCliente.getSegundoApellido() == null)? personaCliente.getApellido() : personaCliente.getApellido() + " " + personaCliente.getSegundoApellido();
    %>
    <tr>
        <td><%= chat.getIdChat() %></td>
        <td><%= apellidos + ", " + nombre %></td>
        <td>
            <%
                if (chat.getEstado() == 0) {
            %>
            Cerrado
            <%
            } else {
            %>
            Abierto
            <%
                }
            %>
        </td>
        <td>
            <a href="/chat?id=<%= chat.getIdChat() %>&esAsistente=true">
            <%
                if (chat.getEstado() == 1) {
            %>
            Chatear
            <%
                } else {
            %>
            Ver chat
            <%
                }
            %>
            </a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
