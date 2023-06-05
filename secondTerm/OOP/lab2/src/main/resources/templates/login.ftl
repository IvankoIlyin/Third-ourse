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
        body {
            background-color: #f7f7f7; /* установка фона для body */
        }

        .form-signin {
            max-width: 350px; /* установка максимальной ширины формы */
            margin: 50px auto 0; /* установка отступов сверху и снизу и автоматическое выравнивание по центру по горизонтали */
            padding: 20px; /* добавление внутреннего отступа для формы */
            border-radius: 10px; /* скругление углов формы */
            box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.1); /* добавление тени для формы */
            background-color: #ffffff; /* установка фона для формы */
        }

        .form-signin label {
            font-weight: 600; /* установка жирного шрифта для label */
        }

        .form-control {
            border-radius: 5px; /* скругление углов для input */
            border: none; /* удаление рамки input */
            background-color: #f5f5f5; /* установка фона для input */
            box-shadow: none; /* удаление тени input */
        }

        .btn-primary {
            background-color: #4c84ff; /* установка цвета фона для кнопки */
            border: none; /* удаление рамки для кнопки */
            box-shadow: none; /* удаление тени для кнопки */
        }

        .btn-primary:hover {
            background-color: #2b55e8; /* изменение цвета фона кнопки при наведении */
        }

        @media (max-width: 767px) {
            .form-signin {
                max-width: 100%; /* установка максимальной ширины формы на маленьких экранах */
                margin: 20px 10px 0; /* установка отступов для формы на маленьких экранах */
            }
        }

        html, body, input, button {
            font-size: 1.2rem;
        }
        .form-signin input,
        .form-signin button {
            margin-bottom: 10px; /* Add 10px margin to bottom of input fields and button */
        }
    </style>


</head>

<body class="text-center">
<form class="form-signin center" action="/login" method="post">
    <label for="inputEmail" class="sr-only">Email:</label>
    <input value="" type="email" maxlength="100" id="inputEmail" name="login" class="form-control" placeholder="Email address" required autofocus>
    <br>
    <label for="inputPassword" class="sr-only">Password:</label>
    <input autocomplete="off" type="password"  maxlength="10" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
    <br>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>

</form>
</body>
</html>