<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="es.taw.gestionbanco.entity.TransaccionEntity" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
Autor: Juan Francisco Sánchez García
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    TransaccionEntity transaccion =  (TransaccionEntity) request.getAttribute("transaccionTipo");
%>

<html>
<head>
    <title>Tipo Transaccion</title>
</head>
<body>
<h1>¿Qué tipo de transacción quiere hacer?</h1>

<table border="1">
    <tr>
        <th><a href="/empresa/hacerPago">Pago</a></th>
        <th><a href="/empresa/hacerCambioDivisa">Cambio de divisa</a></th>
    </tr>
</table>


</body>
</html>