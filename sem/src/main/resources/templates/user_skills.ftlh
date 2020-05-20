<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form method="post" action="/addSkill">
    <input type="text" name="skill">
    <input type="submit">
</form>
<#if ids??>
<#list ids as id>
    <a href="/users + ${id}">User ${id}</a>
</#list>
</#if>
</body>
</html>