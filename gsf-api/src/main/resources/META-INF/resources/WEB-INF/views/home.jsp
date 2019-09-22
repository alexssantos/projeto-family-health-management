<%--
  Created by IntelliJ IDEA.
  User: math
  Date: 22/09/2019
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <title>Home</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/home.css" />
</head>
<body>
<div class="container">
    <h1>Bem vindo(a) ao GSF!</h1>
    <div class="square">
        <div class="square_gestante">
            <img src="imgs/mom.png" />
            <h2>É uma gestante e quer seguir o cronograma gestacional?</h2>
            <p>Faça o login, <a href="/login/gestante">aqui</a>!</p>
            <p>Ainda não possui uma conta? <a href="#">Crie a sua aqui</a></p>
        </div>
        <div class="square_medico">
            <img src="imgs/stethoscope.png" />
            <h2>É um médico e quer acompanhar de perto o cronograma gestacional de suas pacientes?</h2>
            <p>Faça o login, <a href="#">aqui</a>!</p>
            <p>Ainda não possui uma conta? <a href="#">Crie a sua aqui</a></p>
        </div>
    </div>
</div>
</body>
<footer>
    <p>&copy; by 7Team</p>
</footer>
</html>
