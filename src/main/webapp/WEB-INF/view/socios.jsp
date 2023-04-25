<%@ page import="es.taw.gestionbanco.entity.AutorizadoEntity" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

<table border="1">
    <tr>
        <th>ID</th>
        <th>FECHA FIN</th>
        <th>DNI</th>
        <th>CUENTA BANCO</th>
        <th>EMPRESA</th>
        <th>ESTADO</th>
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
    </tr>

    <%
        }
    %>
</table border="1">
<br>
<a href="/empresa/altaSocio">Nuevo autorizado</a>

</body>
</html>