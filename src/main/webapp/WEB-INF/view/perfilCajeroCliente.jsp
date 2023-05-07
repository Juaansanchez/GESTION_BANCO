<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.taw.gestionbanco.entity.ClienteEntity" %><%--
  Created by IntelliJ IDEA.
  User: alvar
  Date: 24/04/2023
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ClienteEntity cliente = (ClienteEntity) request.getAttribute("cliente");
%>
<html>
<head>
    <title>Perfil del cliente </title>
</head>
<body>

<h1>Perfil del cliente <%=cliente.getPersonaById().getNombre()%>
</h1>

<h2>Datos del cliente</h2>

<form action="/cajero/guardarCambiosCliente" method="post">
    <input type="hidden" name="id" value="<%=cliente.getId()%>">
    <input type="hidden" name="dni" value="<%=cliente.getPersonaById().getDni()%>">
    <label>Nombre:</label>
    <input type="text" name="nombre" value="<%=cliente.getPersonaById().getNombre()%>">
    <br>
    <label>Segundo nombre:</label>
    <input type="text" name="segundoNombre" value="<%=cliente.getPersonaById().getSegundoNombre()%>">
    <br>
    <label>Apellido:</label>
    <input type="text" name="apellido" value="<%=cliente.getPersonaById().getApellido()%>">
    <br>
    <label>Segundo Apellido:</label>
    <input type="text" name="segundoApellido" value="<%=cliente.getPersonaById().getSegundoApellido()%>">
    <br>
    <label>Fecha nacimiento:</label>
    <input type="date" name="fechaNacimiento" value="<%=cliente.getPersonaById().getFechaNacimiento()%>">
    <br>
    <label>¿Quiere solicitar la reactivacion?</label>
    <select id="reactivacion" name="reactivacion">
        <option value="si">Sí</option>
        <option value="no" selected>No</option>
    </select>
    <br>
    <input type="submit" value="Guardar cambios">
</form>
</body>
</html>
