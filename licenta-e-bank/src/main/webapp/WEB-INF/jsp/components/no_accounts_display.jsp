<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Container: No Accounts -->
<div class="container">
    <!-- Card: No accounts -->
    <div class="card no-acounts-card">
        <!-- Card Body-->
        <div class="card-body">
            <!-- Card Title -->
            <h2 class="card-title">
                <i class="fas fa-ban text-danger"></i> Niciun cont inregistrat.
            </h2>
            <!-- End Card Title -->
            <hr style="background:transparent; border:0; height:3px" />
            <!-- Card Text -->
            <div class="card-text">
                Momentan nu ai niciun cont bancar inregistrat. <br>
                Apasa mai jos pentru a inregistra / crea un cont nou.
            </div>
            <!-- End Card Text -->


            <button id="accounts-btn" class="btn btn-sm ms-auto mt-5" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
                <i class="fa-regular fa-credit-card me-2"></i>Adauga un cont nou
            </button>

        </div>
        <!-- End Card Body-->
    </div>
    <!-- End Card: No accounts -->
</div>
<!-- End Container: No Accounts -->