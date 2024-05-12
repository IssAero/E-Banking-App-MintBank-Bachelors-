<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Transact form Container  -->
<div class="container d-flex">

    <!-- Transact Button-->
    <button id="transact-btn" class="btn btn-sm" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
        <i class="fa-solid fa-coins me-2"></i>Tranzactii
    </button>
    <!-- End Transact Button-->

    <!-- Accounts Button  -->
    <button id="accounts-btn" class="btn btn-sm ms-auto" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
        <i class="fa-regular fa-credit-card me-2"></i>Adauga un cont nou
    </button>
    <!-- End Accounts Button-->

</div>
<!-- End Transact form Container  -->



<!-- Container: Total Accounts Balance -->
<div class="container">
    <!-- Card: No accounts -->
    <div class="card total-accounts-card">
        <!-- Card Body-->
        <div class="card-body">
            <!-- Card Title -->
            <h3 class="card-title" style="display:inline-block; width:fit-content">Total Conturi:</h3>
                <c:if test="${requestScope.totalBalance != null}">
                    <h3 style="display:inline; vertical-align:top; width:fit-content; margin:auto; float:right" ><c:out value="${totalBalance}"/> RON</h3>
                </c:if>
            <!-- End Card Title -->
        </div>
        <!-- End Card Body-->
    </div>
    <!-- End Card: No accounts -->
</div>
<!-- End Container: Total Accounts Balance -->


<!-- Container: Accordion Menu / Dropdown -->
<div class="container">
    <!-- Accordion Menu / Dropdown -->
    <c:if test="${requestScope.userAccounts != null}">

        <c:forEach items="${requestScope.userAccounts}" var="account">
            <div class="accordion rounded-2" id="accordionFlushExample">
                <div class="accordion-item">
                    <h2 class="accordion-header">
                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-${account.account_id}" aria-expanded="false" aria-controls="flush-collapseOne">
                            ${account.account_name}
                        </button>
                    </h2>
                    <div id="flush-${account.account_id}" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
                        <div class="accordion-body">
                            <!-- Account Details List -->
                            <ul class="list-group list-group-flash">
                                <li class="list-group-item d-flex">Nume cont <span class="ms-auto"><b>${account.account_name}</b></span></li>
                                <li class="list-group-item d-flex">IBAN <span class="ms-auto"><b>${account.account_number}</b></span></li>
                                <li class="list-group-item d-flex">Tip cont <span class="ms-auto"><b>${account.account_type}</b></span></li>
                                <li class="list-group-item d-flex">Balanta cont <span class="ms-auto"><b>${account.balance}</b></span></li>
                                <li class="list-group-item d-flex">Creat pe <span class="ms-auto"><b>${account.created_at}</b></span></li>
                            </ul>
                            <!-- End Account Details List -->
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>

    </c:if>
    <!-- End Accordion Menu / Dropdown -->
</div>
<!-- End Container: Accordion Menu / Dropdown -->