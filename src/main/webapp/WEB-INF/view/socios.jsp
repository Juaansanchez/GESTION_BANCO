<%@ page import="es.taw.gestionbanco.entity.AutorizadoEntity" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
Autor: Juan Francisco Sánchez García
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<AutorizadoEntity> autorizados = (List<AutorizadoEntity>)request.getAttribute("autorizados");
%>

<html>
<head>
    <title>Socios</title>
</head>
<body>
<h1>Listado de socios</h1>


<form:form action="/empresa/filtrarSocios" method="get">
    Buscar por DNI: <input type="text" name="texto">
    <button type="submit">Filtrar</button>
</form:form>
<br>

<form action="/empresa/filtrarSociosPorEstado" method="GET">
    Buscar por estado:    <select name="estado">
        <option value="Autorizado">Autorizado</option>
        <option value="No Autorizado">No Autorizado</option>
    </select>
    <button type="submit">Buscar</button>
</form>
<br>

<form:form action="/empresa/filtrarSociosPorNombreEmpresa" method="get">
    Buscar por nombre de empresa: <input type="text" name="nombreEmpresa">
    <button type="submit">Filtrar</button>
</form:form>
<br>

<table border="1">
    <tr>
        <th>ID</th>
        <th>FECHA FIN</th>
        <th>DNI</th>
        <th>CUENTA BANCO</th>
        <th>EMPRESA</th>
        <th>ESTADO</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <%
        for (AutorizadoEntity autorizado: autorizados) {
    %>
    <tr>
        <td><%= autorizado.getId() %></td>
        <td><%= autorizado.getFechaFin() %></td>
        <td><%= autorizado.getDni() %></td>
        <td><%= autorizado.getCuentabancoByIdCuentaBanco().getIbanCuenta() %></td>
        <td><%= autorizado.getEmpresaByIdEmpresa().getNombre() %></td>
        <td><%= autorizado.getTipoestadoautorizadoByEstadoAutorizado().getEstadoAutorizado() %></td>
        <td><a href="/empresa/editarSocio?id=<%= autorizado.getId() %>"> Editar</a></td>
        <td><a href="/empresa/hacerTransaccion"> Realizar transaccion</a></td>
        <td><a href="/empresa/listarPagos?id=<%= autorizado.getId() %>"> Pagos</a></td>
    </tr>

    <%
        }
    %>
</table border="1">
<br>
<a href="/empresa/altaSocio">Nuevo autorizado</a>

</body>
</html>