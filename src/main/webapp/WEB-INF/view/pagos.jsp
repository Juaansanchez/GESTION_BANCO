<%@ page import="es.taw.gestionbanco.entity.AutorizadoEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.gestionbanco.entity.PagoEntity" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
Autor: Juan Francisco Sánchez García
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<PagoEntity> pagos = (List<PagoEntity>)request.getAttribute("pagos");
%>

<html>
<head>
    <title>Pagos</title>
</head>
<body>
<h1>Listado de pagos</h1>

<form action="/empresa/filtrarPagosPorMonedas" method="GET">
    <select name="moneda">
        <option value="euros">Euros</option>
        <option value="dolar">Dolar</option>
        <option value="libra">Libra</option>
    </select>
    <button type="submit">Buscar</button>
</form>

<br>
<form:form action="/empresa/filtrarPagosPorNombre" method="get">
    Buscar por nombre de beneficiario/a: <input type="text" name="texto">
    <button type="submit">Filtrar</button>
</form:form>
<br>

<form:form action="/empresa/filtrarPagosPorApellido" method="get">
    Buscar por apellido de beneficiario/a: <input type="text" name="texto">
    <button type="submit">Filtrar</button>
</form:form>
<br>
<table border="1">
    <tr>
        <th>ID PAGO</th>
        <th>MONEDA</th>
        <th>CANTIDAD</th>
        <th>ID TRANSACCION</th>
        <th>NOMBRE BENEFICIARIO/A</th>
        <th>APELLIDO BENEFICIARIO/A</th>
    </tr>
    <%
        for (PagoEntity pago: pagos) {
    %>
    <tr>
        <td><%= pago.getIdPago() %></td>
        <td><%= pago.getMoneda() %></td>
        <td><%= pago.getCantidad() %></td>
        <td><%= pago.getTransaccionByIdTransaccion().getId() %></td>
        <td><%= pago.getBeneficiarioByIdBeneficiario().getNombre() %></td>
        <td><%= pago.getBeneficiarioByIdBeneficiario().getApellido() %></td>
    </tr>

    <%
        }
    %>
</table border="1">

</body>
</html>