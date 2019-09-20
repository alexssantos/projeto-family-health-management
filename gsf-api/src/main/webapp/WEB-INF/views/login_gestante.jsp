<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: math
  Date: 16/09/2019
  Time: 09:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login - Gestante</title>
    <meta charset="UTF-8">

<%--    <mvc:resources mapping="/css/login_gestante.css" location="/css/" />--%>
    <link rel="stylesheet" type="text/css" href="../../css/login_gestante.css" />
    <link rel="stylesheet" type="text/css" href="../../css/geral.css" />
</head>
<body>
<div class="container">
    <div class="square">
        <img alt="Logo Mamãe" src="../../imgs/mom.png">
        <form method="post"  action="form">
            <div>
                <input type="text" value="" placeholder="CPF" name="cpf" id="cpf" />
            </div>
            <div>
                <input type="password" value="" placeholder="Senha" name="senha" id="password" />
            </div>
            <div>
                <input type="submit" value="Login" id="botao_login" />
            </div>
            <div class="dentro">
                <div id="linha_login"></div>
                <p id="redirecionamento_cadastro">Ainda não tem conta? <a href="#">Cadastre-se</a></p>
            </div>
        </form>
    </div>
    <footer>
        <p>&copy; by 7Team</p>
    </footer>
</div>
</body>
</html>