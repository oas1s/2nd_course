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
<h1>Ur notes</h1>
    <#if notes?has_content>
    <#list notes as note>
        <p>${note}
    </#list>
            <#else>
            <p>no notes in ur notebook</p>
    </#if>
</body>
</html>