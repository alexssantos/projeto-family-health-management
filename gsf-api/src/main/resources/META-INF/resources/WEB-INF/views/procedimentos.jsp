<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="pt-br">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../../css/style.css"/>
    <title>Quase Mamãe</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"
          integrity="sha256-yMjaV542P+q1RnH6XByCPDfUFhmOafWbeLPmqKh11zo=" crossorigin="anonymous"/>
</head>

<body>
<nav class="navbar navbar-brand" id="navbar">
    <a href="#" class="item"><span class="span-mamae"><img id="mamae" src="../../imgs/mom.svg"/></span></a>
    <a href="#" class="item">Meus Dados</a>
</nav>

<section class="cd-timeline js-cd-timeline">
    <div class="container max-width-lg cd-timeline__container">

        <!-- Inicio -->
        <div class="cd-timeline__block">
            <div class="cd-timeline__img cd-timeline__img--picture">
                <img src="../../imgs/fetus1.jpg" alt="Picture">
            </div> <!-- cd-timeline__img -->
            <div class="cd-timeline__content text-component">
                <h2>Ciclo 1</h2>
                <p class="color-contrast-medium">Parabéns! Você vai ser mamãe! Nessa etapa, o coração do seu bebê já bate.</p>
                <ul class="list-group" style="padding-left:0;">
                    <li class="list-group-item">
                        <form>
                            <c:forEach items="${listaProcedimentos}" var="procedimento" begin="0" end="3">
                                <div class="form-row" style="margin-bottom: -15px;">
                                    <div class="col-md-1">
                                        <input type="checkbox" class="checkbox check">
                                    </div>
                                    <div class="col-md-4">
                                        <strong style="line-height: 2% !important;">${procedimento.descricao}</strong>
                                    </div>
                                    <div class="col-md-3">
                                        <input class="date form-control form-control-sm form-group col-lg-12" type="text"
                                               placeholder="00/00/0000">
                                    </div>
                                    <div class="col-md-2">
                                        <span class="tempo badge" style="margin-top:10px;">${procedimento.semanaInicial} -- ${procedimento.semanaFinal}</span>
                                    </div>
                                    <div class="col-md-2 text-center">
                                        <img class="status center" style="width:50%" src="../../imgs/posterior.jpg"
                                             alt="Picture" data-toggle="tooltip" data-placement="top" title=""
                                             data-original-title="Concluído">
                                    </div>
                                </div>
                            </c:forEach>
                        </form>
                    </li>
                </ul>
            </div>
        </div>
        <%--Fim--%>

        <%--Início--%>
        <div class="cd-timeline__block">
            <div class="cd-timeline__img cd-timeline__img--picture">
                <img src="../../imgs/fetus1.jpg" alt="Picture">
            </div> <!-- cd-timeline__img -->
            <div class="cd-timeline__content text-component">
                <h2>Ciclo 1</h2>
                <ul class="list-group" style="padding-left:0;">
                    <li class="list-group-item">
                        <form>
                            <c:forEach items="${listaProcedimentos}" var="procedimento" begin="4" end="7">
                                <div class="form-row" style="margin-bottom: -15px;">
                                    <div class="col-md-1">
                                        <input type="checkbox" class="checkbox check">
                                    </div>
                                    <div class="col-md-4">
                                        <strong style="line-height: 2% !important;">${procedimento.descricao}</strong>
                                    </div>
                                    <div class="col-md-3">
                                        <input class="date form-control form-control-sm form-group col-lg-12" type="text"
                                               placeholder="00/00/0000">
                                    </div>
                                    <div class="col-md-2">
                                        <span class="tempo badge" style="margin-top:10px;">${procedimento.semanaInicial} -- ${procedimento.semanaFinal}</span>
                                    </div>
                                    <div class="col-md-2 text-center">
                                        <img class="status center" style="width:50%" src="../../imgs/posterior.jpg"
                                             alt="Picture" data-toggle="tooltip" data-placement="top" title=""
                                             data-original-title="Concluído">
                                    </div>
                                </div>
                            </c:forEach>
                        </form>
                    </li>
                </ul>
            </div>
        </div>
        <%--Fim--%>

        <!-- Inicio -->
        <div class="cd-timeline__block">
            <div class="cd-timeline__img cd-timeline__img--picture">
                <img src="../../imgs/fetus1.jpg" alt="Picture">
            </div> <!-- cd-timeline__img -->
            <div class="cd-timeline__content text-component">
                <h2>Ciclo 1</h2>
                <ul class="list-group" style="padding-left:0;">
                    <li class="list-group-item">
                        <form>
                            <c:forEach items="${listaProcedimentos}" var="procedimento" begin="8" end="11">
                                <div class="form-row" style="margin-bottom: -15px;">
                                    <div class="col-md-1">
                                        <input type="checkbox" class="checkbox check">
                                    </div>
                                    <div class="col-md-4">
                                        <strong style="line-height: 2% !important;">${procedimento.descricao}</strong>
                                    </div>
                                    <div class="col-md-3">
                                        <input class="date form-control form-control-sm form-group col-lg-12" type="text"
                                               placeholder="00/00/0000">
                                    </div>
                                    <div class="col-md-2">
                                        <span class="tempo badge" style="margin-top:10px;">${procedimento.semanaInicial} -- ${procedimento.semanaFinal}</span>
                                    </div>
                                    <div class="col-md-2 text-center">
                                        <img class="status center" style="width:50%" src="../../imgs/posterior.jpg"
                                             alt="Picture" data-toggle="tooltip" data-placement="top" title=""
                                             data-original-title="Concluído">
                                    </div>
                                </div>
                            </c:forEach>
                        </form>
                    </li>
                </ul>
            </div>
        </div>
        <%--Fim--%>

        <%--Início--%>
        <div class="cd-timeline__block">
            <div class="cd-timeline__img cd-timeline__img--picture">
                <img src="../../imgs/fetus1.jpg" alt="Picture">
            </div> <!-- cd-timeline__img -->
            <div class="cd-timeline__content text-component">
                <h2>Ciclo 1</h2>
                <ul class="list-group" style="padding-left:0;">
                    <li class="list-group-item">
                        <form>
                            <c:forEach items="${listaProcedimentos}" var="procedimento" begin="12" end="16">
                                <div class="form-row" style="margin-bottom: -15px;">
                                    <div class="col-md-1">
                                        <input type="checkbox" class="checkbox check">
                                    </div>
                                    <div class="col-md-4">
                                        <strong style="line-height: 2% !important;">${procedimento.descricao}</strong>
                                    </div>
                                    <div class="col-md-3">
                                        <input class="date form-control form-control-sm form-group col-lg-12" type="text"
                                               placeholder="00/00/0000">
                                    </div>
                                    <div class="col-md-2">
                                        <span class="tempo badge" style="margin-top:10px;">${procedimento.semanaInicial} -- ${procedimento.semanaFinal}</span>
                                    </div>
                                    <div class="col-md-2 text-center">
                                        <img class="status center" style="width:50%" src="../../imgs/posterior.jpg"
                                             alt="Picture" data-toggle="tooltip" data-placement="top" title=""
                                             data-original-title="Concluído">
                                    </div>
                                </div>
                            </c:forEach>
                        </form>
                    </li>
                </ul>
            </div>
        </div>
        <%--Fim--%>
</section>
</body>

</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"
        integrity="sha256-4iQZ6BVL4qNKlQ27TExEhBN1HFPvAvAMbFavKKosSWQ=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/locale/pt-br.js"
        integrity="sha256-aIToY7VLU5x+toAJcyINV0WEogFBCIVeeWhyUbCaYiQ=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"
        integrity="sha256-5YmaxAwMjIpMrVlK84Y/+NjCpKnFYa8bWWBbUHSBGfU=" crossorigin="anonymous"></script>
<script src="assets/js/main.js"></script>
</body>

</html>