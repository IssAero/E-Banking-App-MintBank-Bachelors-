<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/fontawesome/css/all.min.css">
    <link rel="stylesheet" href="css/default.css">
    <title>Formular Logare</title>
</head>
<body class="d-flex align-items-center justify-content-center">

<!-- Card: Login Form Card  -->
<div class="card login-form-card col-4 bg-transparent border-0">
    <!-- Card Body  -->
    <div class="card-body">
        <!-- Form Header  -->
        <h1 class="form-header card-title mb-3">
            <i class="fa fa-user-circle"></i> Logare Utilizator
        </h1>
        <!-- End Form Header  -->

        <!-- Success Message -->
        <c:if test = "${requestScope.success != null}">
            <div class="alert alert-success text-center border border-success">
                <b>${requestScope.success}</b>
            </div>
        </c:if>
        <!-- End Success Message -->

        <!-- Login Form  -->
        <form action="" class="login-form">
            <!-- Form Group  -->
            <div class="form-group-email col">
                <input type="email" name="email_address" class="form-control form-control-lg" placeholder="Introduceti adresa de email"/><i class="fa-regular fa-envelope"></i>
            </div>
            <!-- End Form Group  -->
            <!-- Row  -->
            <div class="row">
                <!-- Form Group  -->
                <div class="form-group-password col">
                    <input type="password" name="password" class="form-control form-control-lg" placeholder="Introducei o parola"/><i class="fa-solid fa-key"></i>
                </div>
                <!-- End Form Group  -->
            </div>
            <!-- Form Group  -->
            <div class="form-group col">
                <button class="btn btn-lg">Logare</button>
            </div>
            <!-- End Form Group  -->
        </form>
        <!-- End Login Form  -->

        <!-- Card Text  -->
        <p class="card-text my-2">
            Nu ai cont? <span class="ms-2"><a href="/register" class="btn btn-sm text-muted">Inregistrare</a></span>
        </p>
        <!-- End Card Text  -->

        <!-- Back button to landing page  -->
        <small class="">
            <i class="fa fa-arrow-left me-1"></i><a href="/" class="btn btn-sm text-black">Inapoi</a>
        </small>
        <!-- End Back button to landing page  -->
    </div>
    <!-- End Card Text  -->
    <!-- End Card: Login Form Card  -->
</body>
</html>