<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/fontawesome/css/all.min.css">
    <link rel="stylesheet" href="css/default.css">
    <title>Eroare</title>
</head>
<body class="d-flex align-items-center justify-content-center">

<!-- Error Card -->
<div id="sample-text-card" class="card col-3 alert alert-danger border border-danger" align="center">
    <!-- Card Title-->
    <h3 class="card-title">
        <i class="fa-solid fa-triangle-exclamation text-danger"></i>
        <hr style="background: transparent; border:0" />
        <!-- Card  Body  -->
        <div class="card-body">
            <!-- Card text  -->
            <p class="card-text text-danger">
                <!-- Display Message -->
                <c:if test = "${requestScope.error != null}">
            <div class="text-danger text-center border">
                <b>${requestScope.error}</b>
            </div>
            </c:if>
            <!-- End Display Message -->
            </p>
            <!-- End Card text  -->
            <hr style="background:transparent; border:0; height:5px" />
            <a href="/login" class="btn btn-sm btn-danger">
                <i class="fa fa-arrow-left me-1"></i>Back
            </a>
        </div>
        <!-- End Card Body  -->
    </h3>
    <!-- End Card Title-->
</div>
<!-- End Error Card -->
</body>
</html>