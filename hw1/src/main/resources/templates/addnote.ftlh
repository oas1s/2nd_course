<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Add Notes</title>
</head>
<body>
<nav>
    <div class="nav-wrapper">
        <a href="#" class="brand-logo">Logo</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><a href="/notes/0">Notes</a></li>
        </ul>
    </div>
</nav>
<h1>Добавьте свою заметку</h1>
<form method="post" action="/addnotes">
    <div class="row">
        <div class="input-field col s2">
            <input id="nameofnote" type="text" name="name" class="validate">
            <label for="nameofnote">Название заметки</label>
        </div>
    </div>
    <div class="row">
        <div class="input-field col s9">
            <input id="textofnote" type="text" name="text" class="validate">
            <label for="textofnote">Текст заметки</label>
        </div>
    </div>
<#--    <input placeholder="Введите имя заметки" type="text" name="name">-->
<#--    <input placeholder="Введите заметку" type="text" name="text">-->
<#--    <input type="submit" name="submitbutton">-->
    <button class="btn waves-effect waves-light" type="submit" name="action">Submit
        <i class="material-icons right">send</i>
    </button>
</form>
<script type="text/javascript" src="js/materialize.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>