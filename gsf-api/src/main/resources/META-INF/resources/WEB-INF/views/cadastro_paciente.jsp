<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Criar Conta - Gestante</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../../css/cadastro_paciente.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/geral.css"/>
</head>
<body>
    <div class="container">
        <c:if test="${resposta != null}">
            <h1>${resposta}</h1>
        </c:if>
        <div class="square">
            <img alt="Logo Mamãe" src="../../imgs/mom.png">

            <form method="post"  action="${actionSalvarAtualizar}" >
                <input type="hidden" name="id" value="${paciente.id}">
                <input type="hidden" name="usuario.id" value="${paciente.usuario.id}">
                <input type="text" value="${paciente.nome}" placeholder="Nome" name="nome" class="campo" />
                <input type="text" value="${paciente.dataNascimento}" placeholder="Data de Nascimento" name="dataNascimento" class="campo" />
                <input type="text" value="${paciente.dataGravidez}" placeholder="Data da Gravidez" name="dataGravidez" class="campo" />
                <input type="text" value="${paciente.usuario.login}" placeholder="Email" name="usuario.login" class="campo" />
                <input type="password" value="${paciente.usuario.password}" placeholder="Senha" name="usuario.password" class="campo" />

            <c:choose>
                <c:when test="${paciente != null}">
                    <input type="submit" value="Alterar" id="botao_cadastro" />
                    <div class="rodape_campos">
                        <div class="linha"></div>
                        <p class="redirecionamento_cadastro">Já tem uma conta? <a href="#">Ir para login</a></p>
                    </div>
                    </form>
                </c:when>
                <c:when test="${paciente == null}">
                    <input type="submit" value="Criar" id="botao_cadastro" />
                    <div class="rodape_campos">
                        <div class="linha"></div>
                        <p class="redirecionamento_cadastro">Já tem uma conta? <a href="#">Ir para login</a></p>
                    </div>
                    </form>
                </c:when>
            </c:choose>


            <c:if test="${paciente != null}">
                <form method="post" action="/paciente/excluir">
                    <input type="hidden" name="id" value="${paciente.id}">
                    <button type="submit">Excluir meus dados</button>
                </form>
            </c:if>

        </div>
    </div>
</body>
<footer>
    <p>&copy; by 7Team</p>
</footer>
</html>