<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en" class="no-js">
<!--<![endif]-->
<head>
    <meta charset="UTF-8" />
    <title>Форма регистрации и входа</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/main/demo.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/main/style.css"/>" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/main/animate-custom.css"/>" />
</head>
<body>
<div class="container">
    <header>
        <h1>Форма регистрации и входа. <span> Здравствуй, Друг </span></h1>
        <nav class="codrops-demos">
            <span>Нажмите <strong>"Регистрация"</strong> для перехода в меню регистрации. </span>
        </nav>
    </header>
    <section>
        <div id="container_demo" >
            <a class="hiddenanchor" id="toregister"></a>
            <a class="hiddenanchor" id="tologin"></a>
            <div id="wrapper">
                <div id="login" class="animate form">
                    <form  action="" autocomplete="on" method="post">
                        <h1>Вход</h1>
                        <p>
                            <label for="username" class="uname" data-icon="u" > Ваш e-mail или логин</label>
                            <input id="username" name="username" required="required" type="text" placeholder="sitehere или sitehere.ru@my.com"/>
                        </p>
                        <p>
                            <label for="password" class="youpasswd" data-icon="p"> Ваш пароль </label>
                            <input id="password" name="password" required="required" type="password" placeholder="например 123456" />
                        </p>
                        <p class="keeplogin">
                            <input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" />
                            <label for="loginkeeping">Запомнить меня</label>
                        </p>
                        <p class="login button">
                            <input type="submit" value="Войти" />
                        </p>
                        <p class="change_link">
                            Не зарегистрированы еще ?
                            <a href="#toregister" class="to_register"> Регистрация </a>
                        </p>
                    </form>
                </div>

                <div id="register" class="animate form">
                    <form  action="" autocomplete="on" method="post">
                        <h1> Регистрация </h1>
                        <p>
                            <label for="usernamesignup" class="uname" data-icon="u">Ваш логин</label>
                            <input id="usernamesignup" name="usernamesignup" required="required" type="text" placeholder="myname1" />
                        </p>
                        <p>
                            <label for="emailsignup" class="youmail" data-icon="e" > Ваш e-mail</label>
                            <input id="emailsignup" name="emailsignup" required="required" type="email" placeholder="sitehere.ru@my.com"/>
                        </p>
                        <p>
                            <label for="passwordsignup" class="youpasswd" data-icon="p">Ваш пароль </label>
                            <input id="passwordsignup" name="passwordsignup" required="required" type="password" placeholder="123456"/>
                        </p>
                        <p>
                            <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Подтвердите ваш пароль </label>
                            <input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password" placeholder="123456"/>
                        </p>
                        <p class="signin button">
                            <input type="submit" value="Регистрация"/>
                        </p>
                        <p class="change_link">
                            Уже зарегистрированы ?
                            <a href="#tologin" class="to_register"> Войдите на сайт </a>
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </section>
</div>
</body>
</html>

