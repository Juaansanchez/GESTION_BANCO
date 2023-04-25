<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Editar Autorizado</title>
</head>
<body>
<h1>Datos del autorizado:</h1>

<form:form action="/empresa/guardarAutorizado" modelAttribute="autorizado" method="post">
    <form:hidden path="id"/>
    fecha fin: <form:input type="date" path="fechaFin" size="15" maxlength="15"></form:input><br><br>
    DNI*: <form:input path="dni" size="15" maxlength="15"></form:input><br><br>
    Cuenta banco (id)*: <form:select path="cuentabancoByIdCuentaBanco" items="${idCuentas}"></form:select><br><br>
    Empresa (id)*: <form:select path="empresaByIdEmpresa" items="${idEmp}"></form:select><br><br>
    Estado (1 - Autorizado
    2 - No Autorizado)*: <form:select path="tipoestadoautorizadoByEstadoAutorizado" items="${idEstados}"></form:select><br><br>
    <form:button>Guardar</form:button>
</form:form>

</body>
</html>