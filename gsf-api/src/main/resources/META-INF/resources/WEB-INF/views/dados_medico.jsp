<%--
  Created by IntelliJ IDEA.
  User: math
  Date: 22/09/2019
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <title>Meus Dados</title>
    <meta charset="UTF-8">
    <link rel="stylesheet"type="text/css" href="css/dados.css" />
    <link rel="stylesheet"type="text/css" href="css/dados_medico.css" />
    <link rel="stylesheet" type="text/css" href="css/procedimentos.css" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
</head>
<body>
    <nav class="navbar navbar-brand" id="navbar">
        <a href="#"><span class="span-mamae"><img id="mamae" src="imgs/mom.svg" /></span></a>
        <a href="#" class="item">Meus Dados</a>
        <a href="#" class="item">Lista de Gestantes</a>
    </nav>
    <div class="container">
        <div class="square">
            <h1>Olá Médico!</h1>
            <form method="post"  action="form">
                <p id="campo_nome"> Nome: Médico </p>
                <p id="campo_crm"> CRM: 12345678900 </p>
                <p id="campo_email"> E-mail: email@email.com </p>
                <input type="submit" value="Editar" id="botao_editar" />
            </form>
        </div>
    </div>
</body>
<footer>
    <p>&copy; by 7Team</p>
</footer>
</html>
