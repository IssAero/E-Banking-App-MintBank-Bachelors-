<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/fontawesome/css/all.min.css">
    <link rel="stylesheet" href="css/default.css">
    <title>Formular Inregistrare</title>
</head>
<body class="d-flex align-items-center justify-content-center">

<!-- Card: Registration Form Card  -->
<div class="card registration-form-card col-6 bg-transparent border-0">
    <!-- Card Body  -->
    <div class="card-body">
        <!-- Form Header  -->
        <h1 class="form-header card-title mb-3">
            <i class="fa fa-edit"></i> Inregistrare Utilizator Nou
        </h1>
        <!-- End Form Header  -->


        <!-- Registration Form  -->
        <form:form action="/register" class="reg-form" modelAttribute="registerUser">
            <!-- Row  -->
            <div class="row">
                <!-- Form Group  -->
                <div class="form-group-last col">
                    <form:input type="text" path="last_name" class="form-control form-control-lg" placeholder="Introduceti numele"/><i class="fa-regular fa-user"></i>
                    <form:errors path="last_name" class="text-danger"/>
                </div>
                <!-- End Form Group  -->

                <!-- Form Group  -->
                <div class="form-group-first col">
                    <form:input type="text" path="first_name" class="form-control form-control-lg" placeholder="Introduceti prenumele"/><i class="fa-regular fa-user"></i>
                    <form:errors path="first_name" class="text-danger"/>
                </div>
                <!-- End Form Group  -->
            </div>
            <!-- End Row  -->

            <!-- Form Group  -->
            <div class="form-group-email-register col">
                <form:input type="email" path="email" class="form-control form-control-lg" placeholder="Introduceti adresa de email"/><i class="fa-regular fa-envelope"></i>
                <form:errors path="email" class="text-danger"/>
            </div>
            <!-- End Form Group  -->

            <!-- Row  -->
            <div class="row">
                <!-- Form Group  -->
                <div class="form-group-password-register col">
                    <form:input type="password" path="password" class="form-control form-control-lg" placeholder="Introduceti o parola"/><i class="fa-solid fa-key"></i>
                    <form:errors path="password" class="text-danger"/>
                </div>
                <!-- End Form Group  -->

                <!-- Form Group  -->
                <div class="form-group-confirm-password col">
                    <input type="password" name="confirm_password" class="form-control form-control-lg" placeholder="Repetati parola aleasa"/><i class="fa-solid fa-key"></i>
                    <small class="text-danger">${confirm_pass}</small>
                </div>
                <!-- End Form Group  -->
            </div>
            <!-- End Row  -->

            <!-- Form Group  -->
            <div class="form-group col">
                <button class="btn btn-lg">Inregistrare</button>
            </div>
            <!-- End Form Group  -->
        </form:form>
        <!-- End Registration Form  -->

        <!-- Card Text  -->
        <p class="card-text my-2">
            Ai deja cont? <span class="ms-2"><a href="/login" class="btn btn-sm text-muted">Logare</a></span>

        </p>
        <!-- End Card Text  -->

        <!-- Back button to landing page  -->
        <small class="">
            <i class="fa fa-arrow-left "></i> <a href="/" class="btn btn-sm text-black">Inapoi</a>
        </small>
        <!-- End Back button to landing page  -->

    </div>
    <!-- End Card Text  -->
    <!-- End Card: Registration Form Card  -->
</body>
</html>
