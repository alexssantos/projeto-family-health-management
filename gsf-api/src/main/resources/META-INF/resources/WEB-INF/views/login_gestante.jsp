<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: math
  Date: 16/09/2019
  Time: 09:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <title>Login - Gestante</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/login_gestante.css" />
    <link rel="stylesheet" type="text/css" href="css/geral.css" />
</head>
<body>
<div class="container">
    <div class="square">
        <img alt="Logo Mamãe" src="imgs/mom.png">
        <form method="post" action="form">
                <input type="text" value="" placeholder="CPF" name="cpf" id="campo_cpf" />
                <input type="password" value="" placeholder="Senha" name="senha" id="campo_senha" />
                <input type="submit" value="Login" id="botao_login" />
            <div class="rodape_campos">
                <div id="linha_login"></div>
                <p id="redirecionamento_login">Ainda não tem conta? <a href="#">Cadastre-se</a></p>
            </div>
        </form>
    </div>
</div>
</body>
<footer>
    <p>&copy; by 7Team</p>
</footer>
</html>
