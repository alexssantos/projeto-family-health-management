<%--
  Created by IntelliJ IDEA.
  User: math
  Date: 22/09/2019
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <title>Editar</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/cadastro_medico.css" />
    <link rel="stylesheet" type="text/css" href="css/geral.css" />
</head>
<body>
<div class="container">
    <div class="square">
        <form method="post"  action="form">
            <input type="text" value="" placeholder="Nome" name="nome" id="campo_nome" />
            <input type="text" value="" placeholder="CRM" name="cpf" id="campo_crm" />
            <input type="text" value="" placeholder="E-mail" name="email" id="campo_email" />
            <input type="password" value="" placeholder="Senha" name="senha" id="campo_senha" />
            <input type="password" value="" placeholder="Confirmar Senha" name="confirma senha" id="campo_confirma_senha" />
            <input type="submit" value="Salvar" id="botao_cadastro" />
        </form>
    </div>
</div>
</body>
<footer>
    <p>&copy; by 7Team</p>
</footer>
</html>
