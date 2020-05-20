<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <#include "parts/bootstrap.ftlh">
    <title>Edit Profile</title>
</head>
<body>
<form method="post" action="/edit">
    <div class="form-group">
        <label for="exampleFormControlInput1">Name</label>
        <input type="text" name="name" class="form-control" id="exampleFormControlInput1">
    </div>
    <div class="form-group">
        <label for="exampleFormControlInput1">Education</label>
        <input type="text" name="education" class="form-control" id="exampleFormControlInput1">
    </div>
    <div class="form-group">
        <label for="exampleFormControlInput1">Job</label>
        <input type="text" name="job" class="form-control" id="exampleFormControlInput1">
    </div>
    <div class="form-group">
        <label for="exampleFormControlInput1">Experience</label>
        <input type="text"  name="experience" class="form-control" id="exampleFormControlInput1">
    </div>
    <div class="form-group">
        <label for="exampleFormControlInput1">Country</label>
        <input type="text" name="country"  class="form-control" id="exampleFormControlInput1">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>