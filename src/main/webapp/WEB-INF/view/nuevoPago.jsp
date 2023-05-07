<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="es.taw.gestionbanco.entity.TransaccionEntity" %>
<%@ page import="es.taw.gestionbanco.entity.BeneficiarioEntity" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
Autor: Juan Francisco Sánchez García
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Nuevo Pago</title>
</head>
<body>
<h1>Datos del pago:</h1>

<form:form action="/empresa/guardarPago" modelAttribute="pago" method="post">
    Id*: <form:input path="idPago"></form:input> <br><br>
    Moneda*: <form:input path="moneda" size="20" maxlength="20"></form:input><br><br>
    Cantidad*: <form:input path="cantidad" size="5" maxlength="5"></form:input><br><br>
    idTransaccion:* <form:select path="transaccionByIdTransaccion" items="${transacciones}"></form:select><br><br>
    IdBeneficiario*: <form:select path="beneficiarioByIdBeneficiario" items="${beneficiarios}"></form:select><br><br>
    <form:button>Guardar</form:button>
</form:form>

</body>
</html>