<!DOCTYPE html>
<html>

<head>
    <title>Регистрация</title>
</head>

<body>

    <form action="/registration" method="post">
        Имя пользователя: <input type="text" name="username"><br>
        Эл. почта: <input type="email" name="email"><br>
        Пароль: <input type="password" name="password"><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" value="Зарегистрироваться">
    </form>
    <#if errorMessage??>
        <h2 style="color:  red">${errorMessage}</h2>
    </#if>

</body>

</html>