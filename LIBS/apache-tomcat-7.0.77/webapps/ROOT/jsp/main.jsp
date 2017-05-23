<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/css/input-style.css"/>" rel="stylesheet">
</head>
<body>

<div class="form-style-8">
    <h2>Add user into system</h2>
    <form action="/users" method="get">
        <input type="text" name="name" placeholder="name" />
        <input type="text" name="mail" placeholder="mail" />
        <input type="submit" />
    </form>
</div>
</body>
</html>

