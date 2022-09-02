<!DOCTYPE html>
<meta charset="utf-8" xmlns:form="http://www.w3.org/1999/html" xmlns:form="http://www.w3.org/1999/xhtml">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<head>
    <title>Flower</title>
</head>
<body>

<h2>Добавление новой позиции цветов</h2>
<br><br>
<form action="/admin/saveNewFlower" method="post" enctype="multipart/form-data">

    <table width="40%">
        Название <input type="text" name="title" value="${title}"><br>
        Описание <input type="text" name="description" value="${description}"><br>
        Цена <input type="number" name="price" value="${price}" min="0" step="1" ><br>
        Категория <select name="categoryName">
            <#list allCategory as key, value>
                <option value="${key}">${value}</option>
            </#list>
        </select><br><br><br>
        Фото <br>
        <#assign key=0>
        <#list files as file>
            <#if key == 0>
                <label  class="radio-inline">
                    <input type="radio" name="radioName" id="preview"  value="${file}" checked="checked"/>
                    <input type="file" name="files" value="${key}">
                </label>
                <br>
            <#else>
                <label  class="radio-inline">
                    <input type="radio" name="radioName" id="preview"  value="${file}"/>
                    <input type="file" name="files" value="${key}">
                </label>
                <br>
            </#if>
            <#assign key+=1>
        </#list>
    <input type="hidden" name="id" value="${id}"><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <br>
</table>
<br>
<input type="submit" value="Добавить">

</form>

</body>
</html>
