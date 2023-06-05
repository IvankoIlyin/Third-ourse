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
    <style>
        body {
            background-color: #f8f9fa;
        }

        .form-list {
            max-width: 500px;
            margin: 50px auto;
            background-color: #fff;
            border-radius: 10px;
            padding: 50px;
            text-align: left;
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1);
        }

        .form-list h1 {
            margin-bottom: 30px;
            color: #343a40;
            text-align: center;
        }

        .form-list label {
            font-weight: bold;
            margin-bottom: 10px;
            color: #343a40;
        }

        .form-list input[type="text"],
        .form-list input[type="email"],
        .form-list input[type="password"],
        .form-list input[type="number"] {
            width: 100%;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ced4da;
            background-color: #f8f9fa;
            margin-bottom: 20px;
        }

        .form-list input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        .form-list input[type="submit"]:hover {
            background-color: #0069d9;
        }

        .form-list button[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 20px;
        }

        .form-list button[type="submit"]:hover {
            background-color: #0069d9;
        }

        .form-list a {
            color: #007bff;
        }

        .form-list a:hover {
            color: #0056b3;
        }

        .form-list .error-message {
            color: #dc3545;
            font-size: 0.8rem;
            margin-top: 5px;
        }

        .form-list .success-message {
            color: #28a745;
            font-size: 0.8rem;
            margin-top: 5px;
        }

        .form-list .form-group {
            margin-bottom: 30px;
        }
        form[action="/logout"] {
            margin-top: 30px;
        }

        form[action="/logout"] button[type="submit"] {
            background-color: #2c3e50;
            color: #fff;
            font-size: 18px;
            border-radius: 5px;
            border: none;
            padding: 10px 20px;
            width: 100%;
            max-width: 350px;
            margin: 0;
            margin-right: auto;
            transition: all 0.3s ease;
        }

        form[action="/logout"] button[type="submit"]:hover {
            background-color: #34495e;
        }
        html, body, input, button {
            font-size: 1.2rem;
        }

    </style>
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
<form action="/logout" method="get">
    <button class="btn btn-lg btn-primary btn-block" type="submit" >Logout</button>
</form>
</body>
</html>