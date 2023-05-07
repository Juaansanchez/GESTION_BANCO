<%@ page import="java.util.List" %>
<%@ page import="es.taw.gestionbanco.entity.ClienteEntity" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
Autor: Juan Francisco Sánchez García
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Alta de Empresa</title>
</head>
<body>
<h1>Datos de la empresa:</h1>

<form:form action="/empresa/guardar" modelAttribute="empresa" method="post">
    Id (Cliente)*: <form:select path="id" items="${ids}"></form:select> <br><br>
    Nombre*: <form:input path="nombre" size="40" maxlength="40"></form:input><br><br>
    fechaCierre: <form:input type="date" path="fechaCierre" size="15" maxlength="15"></form:input><br><br>
    <form:button>Guardar</form:button>
</form:form>

</body>
</html>
