<%@ page import="es.taw.gestionbanco.entity.ClienteEntity" %>
<%@ page import="es.taw.gestionbanco.entity.CuentabancoEntity" %><%--
  Created by IntelliJ IDEA.
  User: alvar
  Date: 24/04/2023
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ClienteEntity cliente = (ClienteEntity) request.getAttribute("cliente");
%>
<html>
<head>
    <title>CAJERO</title>
</head>
<body>

<h1>Bienvenido <%=cliente.getId()%> </h1>

<table>
        <tr>
            <th>Nombre: </th>
            <td> <%=cliente.getPersonaById().getNombre()%>,  <%=cliente.getPersonaById().getApellido()%> <%=cliente.getPersonaById().getSegundoApellido()%> </td>
        </tr>
        <tr>
            <th>DNI: </th>
            <td><%=cliente.getNumeroIdentificacion()%></td>
        </tr>
        <tr>
            <th>Acciones: </th>
            <td> <a href="perfilCajeroCliente.jsp?id=<%=cliente.getId()%>">Perfil</a></td>
            <td> <a href="operacionesCajeroCliente.jsp?id=<%=cliente.getId()%>">Operaciones Bancarias</a></td>
        </tr>
</table>

</body>
</html>
