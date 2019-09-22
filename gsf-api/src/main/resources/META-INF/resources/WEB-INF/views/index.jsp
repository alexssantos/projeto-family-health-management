<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java"
         contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<c:forEach items="${listaProcedimentos}" var="procedimento">
    <tr>
        <td>${procedimento.descricao}</td>
    </tr>
</c:forEach>