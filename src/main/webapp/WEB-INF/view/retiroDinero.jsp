<%@ page import="es.taw.gestionbanco.entity.ClienteEntity" %>
<%@ page import="es.taw.gestionbanco.entity.CuentabancoEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Álvaro Alemán Rando
  Date: 07/05/2023
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ClienteEntity cliente = (ClienteEntity) request.getAttribute("cliente");
    List<CuentabancoEntity> cuentasCliente = (List<CuentabancoEntity>) request.getAttribute("cuentasCliente");
%>
<html>
<head>
    <title>Retirada de dinero</title>
</head>
<body>
<h1>Buenas cliente <%=cliente.getPersonaById().getNombre()%>, aquí puede transferir dinero</h1>
<form action="/cajero/retirarDinero" method="post">
    <input type="hidden" name="id" value="<%=cliente.getId()%>">
    <label>Seleccione desde que cuenta quiere hacer la transferencia</label>
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
    <label>Importe a retirar</label>
    <input type="text" name="importe" value="0">
    <br>
    <button type="submit" onclick="mostrarAlerta()">Hacer retirada</button>
</form>
<script>
    function mostrarAlerta() {
        alert("¡Gracias por hacer la retirada!");
    }
</script>
</body>
</html>