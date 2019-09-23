<%--
  Created by IntelliJ IDEA.
  User: math
  Date: 22/09/2019
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <title>Dados</title>
    <link rel="stylesheet"type="text/css" href="css/dados.css" />
    <link rel="stylesheet"type="text/css" href="css/dados_gestante.css" />
    <link rel="stylesheet" type="text/css" href="css/procedimentos.css" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
</head>
<body>
    <nav class="navbar navbar-brand" id="navbar">
        <a href="#"><span class="span-mamae"><img id="mamae" src="imgs/mom.svg" /></span></a>
        <a href="#" class="item">Meus Dados</a>
    </nav>
    <div class="container">
        <div class="square">
            <h1>Olá Gestante!</h1>
            <form method="post"  action="form">
                <input type="text" value="" placeholder="Nome" name="nome" id="campo_nome" />
                <input type="text" value="" placeholder="CPF" name="cpf" id="campo_cpf" />
                <input type="text" value="" placeholder="Início da Gestão" name="inicio" id="campo_inicio" />
                <input type="text" value="" placeholder="E-mail" name="email" id="campo_email" />
                <input type="submit" value="Editar" id="botao_editar" />
            </form>
        </div>
    </div>
</body>
<footer>
    <p>&copy; by 7Team</p>
</footer>
</html>
