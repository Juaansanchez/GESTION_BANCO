<%-- Autor: Ángel Joaquín Rodríguez Rodríguez --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page import="es.taw.gestionbanco.entity.AsistenteEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="es.taw.gestionbanco.entity.ChatEntity" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Nuevo chat...</title>
</head>
<body>
<h1>Nuevo chat</h1>
<form:form method="POST" action="/chat/abrirChat" modelAttribute="nuevoChat">
    <form:hidden path="idChat"/>
    <form:hidden path="clienteByIdCliente"/>
    <form:hidden path="estado" value="1"/>
    Asistente: <form:select path="asistenteByIdEmpleado" items="${listaAsistentes}" itemValue="idAsistente"/>
    <form:button>Abrir chat</form:button>
</form:form>
</body>
</html>