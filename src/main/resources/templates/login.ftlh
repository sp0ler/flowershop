<!DOCTYPE html>
<html>

<head>
    <title>Авторизация</title>
</head>

<body>

    <form action="/login" method="post">
        Эл. почта: <input type="email" name="username"><br>
        Пароль: <input type="password" name="password"><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" value="Вход">
    </form>

    <a href="/registration">Зарегистрироваться</a>

</body>

</html>