<%-- Autor: Ángel Joaquín Rodríguez Rodríguez --%>

<%@ page import="java.util.List" %>
<%@ page import="es.taw.gestionbanco.entity.ChatEntity" %>
<%@ page import="es.taw.gestionbanco.entity.AsistenteEntity" %>
<%@ page import="es.taw.gestionbanco.entity.ClienteEntity" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<ChatEntity> chats = (List<ChatEntity>) request.getAttribute("listaChatsCliente");
    ClienteEntity cliente = (ClienteEntity) request.getAttribute("cliente");
    List<ChatEntity> chatsAbiertos = new ArrayList<ChatEntity>();
%>

<html>
<head>
    <title>Test</title>
</head>
<body>
<h1>Listado de tus chats</h1>

<%
    for (ChatEntity chat : chats) {
        if (chat.getEstado() == 1) {
            chatsAbiertos.add(chat);
        }
    }

    if (chatsAbiertos.size() > 0) {
%>

<table border="1">
    <tr>
        <th>ID</th>
        <th>ASISTENTE</th>
        <th></th>
        <th></th>
    </tr>
    <%
        for (ChatEntity chat : chatsAbiertos) {
            AsistenteEntity asistente = chat.getAsistenteByIdEmpleado();
    %>
    <tr>
        <td><%= chat.getIdChat() %></td>
        <td><%= "Asistente " + asistente.getIdAsistente() %></td>
        <td>
            <a href="/chat?id=<%= chat.getIdChat() %>&esAsistente=false">Chatear</a>
        </td>
        <td>
            <a href="/chat/cerrarChat?id=<%= chat.getIdChat() %>">Cerrar chat</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
<%
    } else {
%>
<h2>No hay chats abiertos.</h2>
<%
    }
%>
<a href="/chat/nuevoChat?idCliente=<%= cliente.getId() %>">Abrir nuevo chat...</a>
</body>
</html>
