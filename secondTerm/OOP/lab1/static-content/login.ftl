<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="img/favicon.ico">

    <title>Login</title>

    <!-- Bootstrap core CSS -->
    <link href="/login/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="/login/css/style.css">

    <style>
        form {
            display: block;
            background: #5B3C67;
            padding: 50px;
            width: 100%;
            color: white;
            margin-right: auto;
            margin-left: auto;
            text-align: center;
        }

        form input {
            box-sizing: border-box;
            padding: 10px;
            margin-bottom: 20px;
        //margin-left: 40%;
            width: 25%;
            height: 35px;
            border: 1px solid #ff8c00;
        }

        .btn {
            width: 25%;
            font-size: 14pt;
            color: white;
            background: #7F113E;
            height: 55px;
            padding: 10px;
            border: 1px solid #F5C4AB;
        }

        .btn:hover {
            border: 1px solid white;
        }

        body{
            background: #3de064;
        }
    </style>

</head>

<body class="text-center">
<form class="form-signin center" action="/login" method="post">
    <label for="inputEmail" class="sr-only">Email:</label>
    <input type="email" maxlength="100" id="inputEmail" name="login" class="form-control" placeholder="Email address" required autofocus>
    <br>
    <label for="inputPassword" class="sr-only">Password:</label>
    <input type="password"  maxlength="10" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
    <br>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>

</form>
</body>
</html>