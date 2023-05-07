<%--
Nombre: Marcos Fernández Aranda
--%>
<%@ page import="es.taw.gestionbanco.entity.ClienteEntity" %>
<%@ page import="es.taw.gestionbanco.entity.BeneficiarioEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.gestionbanco.entity.PagoEntity" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestor</title>
</head>
<body>
<h1>Gestor de Clientes</h1>

<%
    ClienteEntity cliente = (ClienteEntity) request.getAttribute("ClienteSeleccionado");
    BeneficiarioEntity beneficiario = (BeneficiarioEntity) request.getAttribute("Beneficiario");
    List<PagoEntity> pagos = (List<PagoEntity>) request.getAttribute("ListaP");
%>

<strong><a href="/gestor/">Volver al gestor</a></strong>

<h2>Información del cliente</h2>
<table border="1">
<tr>
    <th>Id</th>
    <th>Número de identificación</th>
    <th>Estado de la cuenta</th>
    <th>Fecha de inicio</th>





    <%
        if(beneficiario != null)
        {
    %>
    <th>Nombre</th>
    <th>Apellido</th>
    <th>País</th>
    <th>Fecha de nacimiento</th>
    <th>Moneda</th>
    <th>IBAN</th>
    <th>Número de cuenta</th>
    <th>Swift</th>
    <th>País de la cuenta</th>

    <%
        }
    %>

</tr>
<tr>


    <td><%= cliente.getId() %></td>
    <td><%= cliente.getNumeroIdentificacion() %></td>
    <td><%= cliente.getEstado() %></td>
    <td><%= cliente.getFechaInicio() %></td>

    <%
        if(beneficiario != null)
        {
    %>



    <td><%= beneficiario.getNombre() %></td>
    <td><%= beneficiario.getApellido() %></td>
    <td><%= beneficiario.getPais() %></td>
    <td><%= beneficiario.getFechaNacimiento() %></td>
    <td><%= beneficiario.getMoneda() %></td>
    <td><%= beneficiario.getIbanCuenta() %></td>
    <td><%= beneficiario.getNumeroCuenta() %></td>
    <td><%= beneficiario.getSwift() %></td>
    <td><%= beneficiario.getPaisCuenta() %></td>

    <%
        }
    %>

</tr>
</table>

<a href="/gestor/editar/habilitarCuenta?id=<%= cliente.getId() %>"> Activar Cuenta</a></td>
    <a href="/gestor/editar/deshabilitarCuenta?id=<%= cliente.getId() %>"> Desabilitar Cuenta</a></td>
    <a href="/gestor/editar/marcarCuentaComoSospechosa?id=<%= cliente.getId() %>"> Marcar como sospechoso</a></td>
    <a href="/gestor/editar/eliminarCuenta?id=<%= cliente.getId() %>"> Eliminar Cuenta</a></td></hr>

<%
    if(beneficiario != null)
    {
%>
    <h2>Transacciones</h2></br>

<%
    }else{
%>
    <h2>Este usuario no tiene transacciones</h2></br>
<%
    }
%>


<%
    if(pagos != null)
    {


    for (PagoEntity pago: pagos) {
%>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Moneda</th>
        <th>Cantidad</th>
    </tr>
    <tr>
        <td><%= pago.getIdPago() %></td>
        <td><%= pago.getMoneda() %></td>
        <td><%= pago.getCantidad() %></td>
    </tr>
</table>
<%
    }
    }
%>
</body>
</html>
