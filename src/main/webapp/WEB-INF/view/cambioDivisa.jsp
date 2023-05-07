<%@ page import="es.taw.gestionbanco.entity.ClienteEntity" %>
<%@ page import="es.taw.gestionbanco.entity.CuentabancoEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: alvar
  Date: 07/05/2023
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ClienteEntity cliente = (ClienteEntity) request.getAttribute("cliente");
    List<CuentabancoEntity> cuentasCliente = (List<CuentabancoEntity>) request.getAttribute("cuentasCliente");
%>
<html>
<head>
    <title>Cambio de divisa y retirada</title>
</head>
<body>
<h1>Buenas cliente <%=cliente.getPersonaById().getNombre()%>, aquí puede transferir dinero</h1>
<form action="/cajero/cambioDivisa" method="post">
    <input type="hidden" name="id" value="<%=cliente.getId()%>">
    <label>Seleccione desde que cuenta quiere cambiar divisas </label>
    <select id="cuentaBanco" name="cuentaBanco">
        <%
            for (CuentabancoEntity c : cuentasCliente) {
        %>
        <option value="<%=c.getIbanCuenta()%>>"><%=c.getIbanCuenta()%>
        </option>
        <%
            }
        %>
        <br>
    </select>
    <br>
    <label>Importe a cambiar</label>
    <input type="text" name="importe" value="0">
    <br>
    <label>Seleccione a que divisa quiere cambiar: </label>
    <select id="divisa" name="divisa">
        <option value="libras" selected>Libras</option>
        <option value="dollar">Dolar</option>
    </select>
    <br>
    <button type="submit" onclick="mostrarAlerta()">Hacer cambio</button>
</form>

<script>
    function mostrarAlerta() {
        alert("¡Gracias por hacer el cambio de divisa!");
    }
</script>

</body>
</html>