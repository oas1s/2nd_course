<!doctype html>
<#import "/spring.ftl" as spring/>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- CSS only -->
    <link rel="stylesheet" type="text/css" href="css/sign_up.css">
    <#include "parts/bootstrap.ftlh">
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    <title>Reg</title>
</head>
<body>
<style>
    .error {
        color: #ff0000;
    }
</style>

<#--<#if ok=false>-->
<#--    <div class="alert alert-danger" role="alert">-->
<#--        A simple danger alert—check it out!-->
<#--    </div>-->
<#--</#if>-->
<#if captcha??>
    <p style="color: red">${captcha}</p>
</#if>
<@spring.bind "signUpDto"/>
<center>
    <div class="wrapper fadeInDown">
        <div id="formContent">
            <form method="post" action="/signUp">
                <div class="fadeIn second">
                    <h3>Email</h3>
                    <@spring.formInput "signUpDto.email"/>
                    <@spring.showErrors "<br>","error"/>
                </div>
                <div class="fadeIn third">
                    <h3>Name</h3>
                    <@spring.formInput "signUpDto.name"/>
                    <@spring.showErrors "<br>","error"/>
                </div>
                <div class="fadeIn fourth">
                    <h3>Password</h3>
                    <@spring.formPasswordInput "signUpDto.password"/>
                    <@spring.showErrors "<br>","error"/>
                    <br>
                </div>
                <div class="fadeIn fifth">
                    <div class="g-recaptcha" data-sitekey="6Lf3wvkUAAAAAMBGJFzFJEiiGhG1GXMw9bhraotV"></div>
                    <input type="submit">
                </div>
            </form>
        </div>
    </div>
</center>
</body>
</html>