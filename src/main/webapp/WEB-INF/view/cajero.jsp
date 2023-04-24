<%@ page import="es.taw.gestionbanco.entity.ClienteEntity" %>
<%@ page import="es.taw.gestionbanco.entity.CuentabancoEntity" %><%--
  Created by IntelliJ IDEA.
  User: alvar
  Date: 24/04/2023
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CAJERO</title>
</head>
<body>
<%
    ClienteEntity cliente = (ClienteEntity) request.getAttribute("cliente");
%>
<h1>Bienvenido <%=cliente.getPersonaById().getNombre()%></h1>

<table>
    <thead>
        <tr>
            <td>Nombre completo: </td>
            <td>DNI: </td>
            <td>Acciones: </td>
        </tr>
    </thead>
    <tbody>
    <tr>
        <td> <%=cliente.getPersonaById().getNombre()%> , <%=cliente.getPersonaById().getApellido()%>, <%=cliente.getPersonaById().getSegundoApellido()%></td>
        <td> <%=cliente.getPersonaById().getDni()%></td>
        <td>
            <a href="perfilCajeroCliente.jsp?id=<%=cliente.getId()%>">Perfil</a>
            <a href="operacionesCajeroCliente.jsp?id=<%=cliente.getId()%>">Operaciones Bancarias</a>
        </td>

    </tr>
    </tbody>
</table>

</body>
</html>
