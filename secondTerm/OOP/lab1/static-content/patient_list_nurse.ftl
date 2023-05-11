<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="img/favicon.ico">

    <title>Patient list</title>

    <!-- Bootstrap core CSS -->
    <link href="/login/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="/login/css/style.css">
</head>

<body class="text-center">
<form class="form-list" action="/patients" method="post">
    <h1>Patient list:</h1>
    <#list patients as patien>
        <div>
            <label>Name:</label>
            <label> ${patien.name} </label>
            <br>
            <label>Procedures:</label>
            <input name="${patien.id}_procedures" value= "${patien.procedures}" >
            <br>
            <label>Medicines:</label>
            <input name="${patien.id}_medicines" value= "${patien.medicines}" >
        </div>
        <br>
    </#list>
    <button class="btn btn-lg btn-primary btn-block" type="submit">OK</button>
</form>
</body>
</html>