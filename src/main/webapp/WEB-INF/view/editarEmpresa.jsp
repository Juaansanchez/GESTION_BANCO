<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
Autor: Juan Francisco Sánchez García
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Editar Empresa</title>
</head>
<body>
<h1>Datos de la empresa:</h1>

<form:form action="/empresa/guardar" modelAttribute="empresa" method="post">
    <form:hidden path="id"/>
    Nombre*: <form:input path="nombre" size="40" maxlength="40"></form:input><br><br>
    fechaCierre*: <form:input type="date" path="fechaCierre" size="15" maxlength="15"></form:input><br><br>
    <form:button>Guardar</form:button>
</form:form>

</body>
</html>