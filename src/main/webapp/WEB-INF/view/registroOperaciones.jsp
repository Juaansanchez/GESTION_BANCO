<%@ page import="es.taw.gestionbanco.entity.ClienteEntity" %>
<%@ page import="es.taw.gestionbanco.entity.PagoEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Álvaro Alemán Rando
  Date: 07/05/2023
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ClienteEntity cliente = (ClienteEntity) request.getAttribute("cliente");
    List<PagoEntity> pagos = (List<PagoEntity>) request.getAttribute("pagos");
%>
<html>
<head>
    <title>Registro operaciones</title>
</head>
<body>
<h1>Registro de operaciones</h1>

<table>
    <%
        for (PagoEntity p : pagos) {
    %>
    <tr>
        <th>ID del pago:</th>
        <td><%=p.getIdPago()%>
        </td>
    </tr>
    <tr>
        <th>Moneda</th>
        <td><%=p.getMoneda()%>
        </td>
    </tr>
    <tr>
        <th>Cantidad</th>
        <td><%=p.getCantidad()%>
        </td>
    </tr>
    <tr>
        <th>Fecha instruccion:</th>
        <td><%=p.getTransaccionByIdTransaccion().getFechaInstruccion()%>
        </td>
    </tr>
    <tr>
        <th>Fecha ejecucion:</th>
        <td><%=p.getTransaccionByIdTransaccion().getFechaEjecucion()%>
        </td>
    </tr>
    <%
        }
    %>

</table>

</body>
</html>
