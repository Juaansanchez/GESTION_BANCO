<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
Autor: Juan Francisco Sánchez García
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Nueva Transaccion</title>
</head>
<body>
<h1>Datos de la transaccion:</h1>

<form:form action="/empresa/guardarTransaccion" modelAttribute="transaccion" method="post">
    Id*: <form:input path="id" size="2" maxlength="2"></form:input> <br><br>
    fecha instruccion*: <form:input type="date" path="fechaInstruccion" size="15" maxlength="15"></form:input><br><br>
    fecha ejecucion*: <form:input type="date" path="fechaEjecucion" size="15" maxlength="15"></form:input><br><br>
    <form:button>Guardar</form:button>
</form:form>

</body>
</html>