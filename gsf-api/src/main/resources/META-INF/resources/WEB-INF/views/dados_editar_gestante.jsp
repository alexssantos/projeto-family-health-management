<%--
  Created by IntelliJ IDEA.
  User: math
  Date: 22/09/2019
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <title>Editar</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/cadastro_gestante.css" />
    <link rel="stylesheet" type="text/css" href="css/geral.css" />
</head>
<body>
<div class="container">
    <div class="square">
        <form method="post"  action="form">
            <input type="text" value="" placeholder="Nome" name="nome" id="campo_nome" />
            <input type="text" value="" placeholder="CPF" name="cpf" id="campo_cpf" />
            <input type="text" value="" placeholder="Início da Gestão" name="inicio" id="campo_inicio" />
            <input type="text" value="" placeholder="E-mail" name="email" id="campo_email" />
            <input type="password" value="" placeholder="Senha" name="senha" id="campo_senha" />
            <input type="password" value="" placeholder="Confirmar Senha" name="confirmar senha" id="campo_confirmar_senha" />
            <input type="submit" value="Cadastrar" id="botao_cadastro" />
        </form>
    </div>
</div>
</body>
<footer>
    <p>&copy; by 7Team</p>
</footer>
</html>
