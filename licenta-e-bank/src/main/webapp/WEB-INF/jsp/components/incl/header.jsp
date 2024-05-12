<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Main Page Header  -->
<header class="main-page-header mb-3 bg-dark">
    <!-- Container  -->
    <div class="container d-flex align-items-center">
        <!-- Company Name  -->
        <div class="company-name">
            Evermint Bank
        </div>
        <!-- End Company Name  -->

        <!-- Navigation -->
        <nav class="navigation align-content-center" >
            <li><a href="/app/dashboard">Panou Control</a></li>
            <li><a href="/app/payment_history">Istoric Plati</a></li>
            <li><a href="/app/transact_history">Istoric Tranzactii</a></li>
        </nav>
        <!-- End Navigation -->

        <!-- Display Name-->
        <div class="display-name ms-auto text-white">
            <i class="fa fa-circle text-success me-1"></i> Salut <span class="me-4">${user.first_name} ${user.last_name}!</span>
        </div>
        <!-- End Display Name-->

        <!-- Log out button-->
        <a href="/logout" class="btn btn-sm text-white">
            <i class="fa fa-sign-out-alt ms-1 me-2"></i>Delogare
        </a>
        <!-- End Log out button-->
    </div>
    <!-- End Container  -->
</header>
<!-- End Main Page Header  -->