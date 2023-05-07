<%@ page import="es.taw.gestionbanco.entity.ClienteEntity" %><%--
  Created by IntelliJ IDEA.
  User: Álvaro Alemán Rando
  Date: 24/04/2023
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ClienteEntity cliente = (ClienteEntity) request.getAttribute("cliente");
%>
<html>
<head>
    <title>Operaciones del cliente</title>
</head>
<body>
<h1>Buenas cliente <%=cliente.getPersonaById().getNombre()%>, aquí tiene las operaciones que puede hacer</h1>

<table>
    <tr>
        <th>Transferencia bancaria</th>
        <td><a href="/cajero/transferencias?id=<%=cliente.getId()%>">Click aquí</a></td>
    </tr>
    <tr>
        <th>Sacar dinero</th>
        <td><a href="/cajero/retiroDinero?id=<%=cliente.getId()%>">Click aquí</a></td>
    </tr>
    <tr>
        <th>Cambio de divisas y retirada en la moneda cambiada</th>
        <td><a href="/cajero/cambioDivisa?id=<%=cliente.getId()%>">Click aquí</a></td>
    </tr>
    <tr>
        <th>Ver operaciones</th>
        <td><a href="/cajero/registroOperaciones?id=<%=cliente.getId()%>">Click aquí</a></td>
    </tr>
</table>

</body>
</html>
