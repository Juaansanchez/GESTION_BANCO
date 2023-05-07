<%--
Nombre: Marcos Fernández Aranda
--%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.gestionbanco.entity.EmpresaEntity" %>
<%@ page import="es.taw.gestionbanco.entity.ClienteEntity" %>
<%@ page import="es.taw.gestionbanco.ui.FiltroGestor" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestor</title>
</head>
<body>
<h1>Gestor</h1>

<%
    List<EmpresaEntity> listaEmpresas = (List<EmpresaEntity>) request.getAttribute("listaE");
    List<ClienteEntity> listaClientes = (List<ClienteEntity>) request.getAttribute("listaC");
    FiltroGestor filtro = (FiltroGestor) request.getAttribute("filtro");
%>
<h2>Empresas</h2>



<%
    for (EmpresaEntity empresa: listaEmpresas) {
%>
<table border = "1">
<tr>
    <th>Nombre</th>
    <th>ID</th>
    <th></th>
    <th></th>
    <th></th>
</tr>
<tr>
    <td><%= empresa.getNombre() %></td>
    <td><%= empresa.getId() %></td>
    <td><a href="/gestor/editar?id=<%= empresa.getClienteById().getId() %>"> Editar cuenta cliente de la empresa</a></td>
    <td><a href=""> Editar Empresa</a></td>
    <td><a href=""> Listar Socios</a></td>

</tr>

</table></br>

<%
    }
%>
<h2>Clientes:</h2>

<form:form method="POST" action="/gestor/filtrar" modelAttribute="filtro">

    <form:radiobutton path="estado" value="-1" label="Sin filtro"/>
    <form:radiobutton path="estado" value="0" label="Activos"/>
    <form:radiobutton path="estado" value="1" label="Inactivo"/>
    <form:radiobutton path="estado" value="2" label="Sospechosos"/>
    <form:radiobutton path="estado" value="3" label="Bloqueados"/>
    <form:button>Filtrar</form:button>

</form:form>

<%
    for (ClienteEntity cliente: listaClientes) {
%>


<table border = "1">
    <tr>
        <th>ID</th>
        <th>DNI</th>
        <th>Fecha de creación de la cuenta</th>
        <th>Estado de la cuenta</th>

    </tr>
    <tr>
        <td><%= cliente.getId() %></td>
        <td><%= cliente.getNumeroIdentificacion() %></td>
        <td><%= cliente.getFechaInicio() %></td>
        <td><%= cliente.getEstado() %></td>

        <td><a href="/gestor/editar?id=<%= cliente.getId() %>"> Editar</a></td>

    </tr>

</table></br>
<%
    }
%>


</body>
</html>
