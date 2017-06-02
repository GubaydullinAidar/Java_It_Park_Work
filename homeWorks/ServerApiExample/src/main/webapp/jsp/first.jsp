<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.itpark.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/main/demo.css"/>" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/main/style.css"/>" />
    </head>
    <body>
        <p style="font-size: 120%; font-family: monospace; color: #FFFFFF"> Приветствую вас, <c:out value="${user.name}"/> ! </p>

        <form  action="main">
            <p class="complite button">
                <input type="submit" value="Выйти" />
            </p>
        </form>
    </body>
</html>
