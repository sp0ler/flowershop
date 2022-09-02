<!DOCTYPE html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<head>
    <title>Category</title>
</head>
<body>
<h2>Добавление новой категории</h2>
<br><br>

<form action="/admin/saveNewCategory" method="post" enctype="multipart/form-data">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <table width="40%">
        Название <input type="text" name="categoryName" value="${categoryName}"><br>
        Название английское <input type="text" name="categoryNameEng" value="${categoryNameEng}"><br>
        <input type="hidden" name="id" value="${id}"><br>
        Фото <input type="file" name="file" />
    </table>
    <br>
    <input type="submit" value="Добавить">
</form>

</body>
</html>