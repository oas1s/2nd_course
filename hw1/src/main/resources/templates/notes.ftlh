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
    <title>Notes</title>
</head>
<body>
<nav>
    <div class="nav-wrapper">
        <a href="#" class="brand-logo">Logo</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <li><a href="/addnotes">Add Note</a></li>
        </ul>
    </div>
</nav>
<h1 align="center">Ur notes</h1>
<form method="get" action="/search1/0">
    <div class="row" style="margin-left: 35%">
        <div class="input-field col s6">
            <input id="nameofnote" type="text" name="searchName" class="validate">
            <label for="nameofnote">Поиск заметки</label>
        </div>
    </div>
    <button class="btn waves-effect waves-light" type="submit" name="action"style="margin-left: 48%">Submit
        <i class="material-icons right">send</i>
    </button>
</form>
<#if notes?has_content>
    <#list notes as note>
        <div class="row" style="margin-left: 35%" align="center">
            <div class="col s6 m6" >
                <div class="card blue-grey darken-1">
                    <div class="card-content white-text">
                        <span class="card-title">${note.name}</span>
                        <p>${note.text}</p>
                    </div>
                </div>
            </div>
        </div>
<#--        <p>${note.name}-->
<#--        <p>${note.text}-->
    </#list>
<#else>
    <p>no notes in ur notebook</p>
</#if>
<ul class="pagination" style="
    padding-left: 45%;"
>
    <li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
    <#if palest?has_content>
        <#list palest as pag>
            <li class="active"><a href="/notes/${pag}">${pag}</a></li>
        </#list>
    </#if>
    <li class="waves-effect"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
</ul>
<script type="text/javascript" src="js/materialize.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>