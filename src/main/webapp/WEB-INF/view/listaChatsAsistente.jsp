<%@ page import="es.taw.gestionbanco.entity.PersonaEntity" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<PersonaEntity> personas = (List<PersonaEntity>) request.getAttribute("personas");
%>

<html>
<head>
    <title>Test</title>
</head>
<body>
<h1>Test empresa</h1>
<table>
    <tr>
        <th>DNI</th>
        <th>NOMBRE</th>
        <th>APELLIDOS</th>
    </tr>
    <%
        for (PersonaEntity persona : personas) {
    %>
    <tr>
        <td><%= persona.getDni() %></td>
        <td><%= persona.getNombre() + " " + persona.getSegundoNombre() %></td>
        <td><%= persona.getApellido() + " " + persona.getSegundoApellido() %></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
