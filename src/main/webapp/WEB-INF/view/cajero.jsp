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
    CuentabancoEntity cuentaCliente = (CuentabancoEntity) request.getAttribute("cuentabancoCliente");
%>

<table>
    <thead>
        <tr>
            <td>ID cliente </td>
            <td>Nombre cliente: </td>
            <td>Correo electronico: </td>
            <td>Acciones: </td>
        </tr>
    </thead>
    <tbody>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td>
            <a href="perfilCajeroCliente.jsp?id=1">Perfil</a>
            <a href="operacionesCajeroCliente.jsp?id=1">Operaciones Bancarias</a>
        </td>

    </tr>
    </tbody>
</table>

</body>
</html>
