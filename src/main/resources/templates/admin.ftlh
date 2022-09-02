<!DOCTYPE html>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<meta charset="utf-8">
<head>
    <title>Flower</title>
</head>
<body>
<h2>Список позиций</h2>

<table width="40%">
    <tr>
        <th>Название</th>
        <th>Описание</th>
        <th>Цена</th>
        <th>Вид</th>
        <th>Операции</th>
    </tr>
    <#list adminAllFlower as flower>
        <tr>
            <td>${flower.title}</td>
            <td>${flower.description}</td>
            <td>${flower.price}</td>
            <td>${flower.categoryName}</td>
            <td>
                <form action="/admin/updateFlower/${flower.id}" method="get">
                    <input type="submit" value="Обновить">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                </form>
                <form action="/admin/deleteFlower/${flower.id}" method="get">
                    <input type="submit" value="Удалить">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                </form>
            </td>
        </tr>
        <#else>
        Список пуст
    </#list>
</table>
<br>
<#--<input type="button" value="Добавить" onclick="window.location.href='/admin/addNewFlower'">-->
<form action="/admin/addNewFlower" method="get">
    <input type="submit" value="Добавить позицию">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
</form>

<br><br><br>
<h2>Список категорий</h2>
<br>
<table>
    <tr>
        <th>Номер</th>
        <th>Название</th>
        <th>Операции</th>
    </tr>
    <#list adminAllCategory as category>
        <tr>
            <td>${category.id}</td>
            <td>${category.categoryName}</td>
            <td>
                <form action="/admin/updateCategory/${category.id}" method="get">
                    <input type="submit" value="Обновить">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                </form>
                <form action="/admin/deleteCategory/${category.id}" method="get">
                    <input type="submit" value="Удалить">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                </form>
            </td>
        </tr>
    </#list>

</table>
<form action="/admin/addNewCategory" method="get">
    <input type="submit" value="Добавить категорию">
</form>


</body>
</html>
