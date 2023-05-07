<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modificar datos de Cliente</title>
</head>
<body>


<h1>Modificar datos del cliente:</h1>

<h3>Datos personales:</h3>

<form:form action="/modificarDatos" modelAttribute="datosClientes" method="post">
    NIF(*): <form:input path="persona.dni"></form:input><br>
    Primer nombre(*): <form:input path="persona.nombre" size="80" maxlength="80"></form:input>
    Segundo nombre: <form:input path="persona.segundoNombre" size="80" maxlength="80"></form:input><br/>
    Primer apellido(*): <form:input path="persona.apellido" size="80" maxlength="80"></form:input>
    Segundo apellido: <form:input path="persona.segundoApellido" size="80" maxlength="80"></form:input><br/>
    Fecha nacimiento(*): <form:input type="date" value="2000-01-01" path="persona.fechaNacimiento"></form:input><br/>

    <h3>Dirección:</h3>
    Tipo de vía(*): <form:input path="direccion.tipo"></form:input>
    Nombre de vía(*): <form:input path="direccion.calle"></form:input>
    Número(*): <form:input type="number" path="direccion.numero"></form:input><br>
    Planta/Puerta/Oficina(*): <form:input path="direccion.plantaPuertaOficina" size="80" maxlength="80"></form:input><br>
    Ciudad(*): <form:input path="direccion.ciudad" size="80" maxlength="80"></form:input>
    Región: <form:input path="direccion.region" size="80" maxlength="80"></form:input><br>
    País(*): <form:input path="direccion.pais" size="80" maxlength="80"></form:input>
    CP(*): <form:input type="number" path="direccion.codigoPostal" size="80" maxlength="80"></form:input><br/>
    <form:checkbox path="direccion.valida" value="1" uncheckedValue="false"></form:checkbox>Válida(dirección actual)<br/>
    <br>

    Contraseña(*): <form:password path="pass"></form:password>
    Repetir contraseña(*): <form:password path="repetirPass"></form:password>
    <br>

    <form:button>Guardar</form:button>
    <form:errors path="*" cssClass="error" element="div" />
</form:form>

<button onclick="window.location.href='redirect:/operacionesCliente'">Cancelar</button>

</body>
</html>
