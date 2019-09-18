<%@ page language="java"
         contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<h1>${listaPacientes}</h1>
<h1>${listaPacientes[0].nome}</h1>
<h1>${listaPacientes[0].dataNascimento}</h1>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!--    <link rel="stylesheet" type="text/css"href="sty2.css"/>-->
    <title></title>
</head>
<body>
<H1>Root resources</H1>
<form action="/login" method="post">
    <div class="container">
        <label name="luname"><b>Nome: </b></label>
        <input type="text" placeholder="Enter user name" name="name" required>
        <br>

        <label name="lemail"><b>E-mail: </b></label>
        <input type="text" placeholder="Enter E-mail" name="email" required>
        <br>

        <label name="lpassword"><b>Senha: </b></label>
        <input type="text" placeholder="Enter password" name="password" required>
        <br>

        <button type="submit">Cadastro</button>
        <br>
    </div>

    <!-- Forgot password-->
    <hr>
    <div class="container" style="background-color:#f1f1f1">
        <button type="button" class="cancelbtn">Cancel</button>
        <span class="psw">Forgot <a href="#">password?</a></span>
    </div>
</form>
</body>
</html>
