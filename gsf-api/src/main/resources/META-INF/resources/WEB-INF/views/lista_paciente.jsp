<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <title>Lista de Gestantes</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../../css/lista_paciente.css" />
    <link rel="stylesheet" type="text/css" href="../../css/procedimentos.css" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-brand" id="navbar">
    <a href="#"><span class="span-mamae"><img id="mamae" src="../../imgs/mom.svg" /></span></a>
    <a href="#" class="item">Meus Dados</a>
    <a href="#" class="item">Lista de Gestantes</a>
</nav>
<%--<h1>Minhas Pacientes</h1>--%>
<div class="container">
    <c:forEach items="${listaPacientes}" var="paciente">
        <div class="square">
        <div class="card">
            <h1>Olá, ${login}</h1>
            <h4>Gestante: ${paciente.nome}</h4>
            <p>Data Gravidez: ${paciente.dataGravidez}</p>
        </div>
    </div>
    </c:forEach>
</div>
</body>
<footer>
    <p>&copy; by 7Team</p>
</footer>
</html>