<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login - Gestante</title>
    <meta charset="UTF-8">

    <link rel="stylesheet" type="text/css" href="../../css/login_gestante.css" />
    <link rel="stylesheet" type="text/css" href="../../css/geral.css" />
</head>
<body>
<div class="container">
    <div class="square">
        <img alt="Logo Mamãe" src="../../imgs/mom.png">
        <form method="post" name="usuario"  action="/login/gestante">
            <div>
                <input type="text" value="" placeholder="CPF" name="login" id="cpf" />
            </div>
            <div>
                <input type="password" value="" placeholder="Senha" name="password" id="password" />
            </div>
            <div>
                <button type="submit" id="botao_login">Login</button>
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
