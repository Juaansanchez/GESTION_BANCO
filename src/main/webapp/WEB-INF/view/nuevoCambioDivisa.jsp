<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
Autor: Juan Francisco Sánchez García
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Nuevo cambio de divisas</title>
</head>
<body>
<h1>Datos del cambio de divisas:</h1>

<form:form action="/empresa/guardarCambioDivisa" modelAttribute="cambio" method="post">
    Id transaccion: <form:select path="idTransaccion" items="${transacciones}"></form:select><br><br>
    Moneda venta: <form:input path="monedaVenta"></form:input> <br><br>
    Moneda compra: <form:input path="monedaCompra"></form:input><br><br>
    Tipo de cambio: <form:input path="tipoDeCambio"></form:input><br><br>
    Cantidad compra: <form:input path="cantidadCompra" size="5" maxlength="5"></form:input><br><br>
    Cantidad venta: <form:input path="cantidadVenta" size="5" maxlength="5"></form:input><br><br>

    <form:button>Guardar</form:button>
</form:form>

</body>
</html>