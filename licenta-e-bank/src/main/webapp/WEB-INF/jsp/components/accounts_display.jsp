<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Transact form Container  -->
<div class="container d-flex">

    <!-- Transact Button-->
    <button id="transact-btn" class="btn btn-sm" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
        <i class="fa-solid fa-coins me-2"></i>Tranzacții
    </button>
    <!-- End Transact Button-->

    <!-- Accounts Button  -->
    <button id="accounts-btn" class="btn btn-sm ms-auto" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
        <i class="fa-regular fa-credit-card me-2"></i>Adaugă un cont nou
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
            <h3 class="card-title" style="display:inline; margin-right: 77%;">Total Conturi:</h3>
                <c:if test="${requestScope.totalBalance != null}">
                    <c:out value="${totalBalance}"/>
                </c:if>
            <h3 class="currency ms-1" style="display:inline">RON</h3>
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
    <div class="accordion accordion-flush" id="accordionFlushExample">
        <div class="accordion-item">
            <h2 class="accordion-header">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                    Accordion Item #1
                </button>
            </h2>
            <div id="flush-collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
                <div class="accordion-body">Placeholder content for this accordion, which is intended to demonstrate the <code>.accordion-flush</code> class. This is the first item's accordion body.</div>
            </div>
        </div>
        <div class="accordion-item">
            <h2 class="accordion-header">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
                    Accordion Item #2
                </button>
            </h2>
            <div id="flush-collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
                <div class="accordion-body">Placeholder content for this accordion, which is intended to demonstrate the <code>.accordion-flush</code> class. This is the second item's accordion body. Let's imagine this being filled with some actual content.</div>
            </div>
        </div>
        <div class="accordion-item">
            <h2 class="accordion-header">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseThree" aria-expanded="false" aria-controls="flush-collapseThree">
                    Accordion Item #3
                </button>
            </h2>
            <div id="flush-collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
                <div class="accordion-body">Placeholder content for this accordion, which is intended to demonstrate the <code>.accordion-flush</code> class. This is the third item's accordion body. Nothing more exciting happening here in terms of content, but just filling up the space to make it look, at least at first glance, a bit more representative of how this would look in a real-world application.</div>
            </div>
        </div>
    </div>
    <!-- End Accordion Menu / Dropdown -->
</div>
<!-- End Container: Accordion Menu / Dropdown -->