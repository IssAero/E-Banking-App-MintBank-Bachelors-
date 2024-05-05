<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="shortcut icon" href="#"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../css/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/fontawesome/css/all.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <script src="../js/bootstrap.bundle.js"></script>
    <title>Dashboard</title>
</head>
<body>

    <!-- Header -->
    <c:import url="components/incl/header.jsp"/>

    <!-- Container -->
    <div class="container">
        <!-- Display Message -->
        <c:if test = "${success != null}">
            <div class="alert alert-success text-center border border-success">
                <b>${success}</b>
            </div>
        </c:if>
        <!-- End Display Message -->

        <!-- Display Message -->
        <c:if test = "${error != null}">
            <div class="alert alert-danger text-center border border-danger">
                <b>${error}</b>
            </div>
        </c:if>
        <!-- End Display Message -->
    </div>
    <!-- End Container -->

    <!-- Transact Offcanvas: Right Side -->
    <c:import url="components/transact_offcanvas.jsp"/>

    <!-- Add Accounts Offcanvas: Left Side -->
    <c:import url="components/add_accounts_offcanvas.jsp"/>


    <c:choose>
        <c:when test="${fn:length(userAccounts) > 0}">
            <!-- Display Accounts -->
            <c:import url="components/accounts_display.jsp"/>
        </c:when>
        <c:otherwise>
            <!-- Dont Display Account -->
            <c:import url="components/no_accounts_display.jsp"/>
        </c:otherwise>
    </c:choose>


    <!-- Footer -->
    <c:import url="components/incl/footer.jsp"/>

