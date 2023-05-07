<%@ page import="org.springframework.validation.ObjectError" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<ObjectError> errores = (List<ObjectError>) request.getAttribute("errores");
%>
<html>
<head>
    <title>Error</title>
</head>
<body>

<h1>Error en el formulario</h1>

<% if (errores != null && !errores.isEmpty()) { %>
<div class="alert alert-danger">
    <ul>
        <% for (ObjectError error : errores) { %>
        <li><%=error.getDefaultMessage()%></li>
        <% } %>
    </ul>
</div>
<% } else { %>
<h3>Hubo un error al introducir los datos en la base de datos</h3>
<%} %>

<button onclick="window.location.href='/'">Volver</button>

</body>
</html>
