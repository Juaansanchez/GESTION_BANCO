<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Juan
  Date: 20/04/2023
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Alta de Empresa</title>
</head>
<body>
<h1>Datos de la empresa:</h1>

<form:form action="/guardar" modelAttribute="empresa" method="post">
    Id (Cliente): <form:input path="id"></form:input>
    Nombre: <form:input path="nombre" size="80" maxlength="80"></form:input><br/>
    fechaCierre: <form:input path="fechaCierre" size="50" maxlength="50"></form:input>
    <form:button>Guardar</form:button>
</form:form>

</body>
</html>
