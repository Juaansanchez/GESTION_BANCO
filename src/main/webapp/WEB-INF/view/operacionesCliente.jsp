<%@ page import="es.taw.gestionbanco.entity.PersonaEntity" %>
<%@ page import="es.taw.gestionbanco.controller.ClientSignUpController" %>
<%@ page import="es.taw.gestionbanco.entity.DireccionEntity" %>
<%@ page import="es.taw.gestionbanco.auxiliar.DatosClientes" %>
<%@ page import="org.springframework.web.servlet.support.RequestContextUtils" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    DatosClientes datosClientes = (DatosClientes) request.getAttribute("datosClientes");
    PersonaEntity persona = datosClientes.getPersona();
    DireccionEntity direccion = datosClientes.getDireccion();

    String mensaje = (String) RequestContextUtils.getOutputFlashMap(request).get("mensaje");
%>
<html>
<head>
    <title>Operaciones cliente</title>
</head>
<body>

<% if(mensaje != null && !mensaje.isEmpty()) {%>
    <div style="color: green;"><%=mensaje%>/div>
<% } %>

<h1>Datos cliente:</h1>
<h3>Personal:</h3>
<ul>
    <li><strong>ID:</strong> <%=persona.getId()%></li>
    <li><strong>DNI:</strong> <%=persona.getDni()%></li>
    <li><strong>Nombre:</strong> <%=persona.getNombre()%></li>
    <li><strong>Segundo nombre:</strong> <%=persona.getSegundoNombre()%></li>
    <li><strong>Apellido:</strong> <%=persona.getApellido()%></li>
    <li><strong>Segundo apellido:</strong> <%=persona.getSegundoApellido()%></li>
    <li><strong>Fecha de nacimiento:</strong> <%=persona.getFechaNacimiento()%></li>
</ul>

<h3>Direccion:</h3>
<ul>
    <li><strong>ID:</strong> <%=direccion.getId()%> </li>
    <li><strong>Tipo de vía:</strong> <%=direccion.getTipo()%> </li>
    <li><strong>Nombre de vía:</strong> <%=direccion.getCalle()%> </li>
    <li><strong>Número:</strong> <%=direccion.getNumero()%> </li>
    <li><strong>Planta/Puerta/Oficina:</strong> <%=direccion.getPlantaPuertaOficina()%> </li>
    <li><strong>Ciudad:</strong> <%=direccion.getCiudad()%> </li>
    <li><strong>Región:</strong> <%=direccion.getRegion()%> </li>
    <li><strong>País:</strong> <%=direccion.getPais()%> </li>
    <li><strong>Código Postal:</strong> <%=direccion.getCodigoPostal()%> </li>
    <li><strong>Válida:</strong> <%=direccion.getValida()%></li>
</ul>

<h3>Operaciones:</h3>

<button onclick="window.location.href='redirect:/modificarCliente'">Modificar datos</button>

</body>
</html>
