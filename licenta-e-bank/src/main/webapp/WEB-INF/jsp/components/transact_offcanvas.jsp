<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!-- Start transact OffCanvas  -->
<div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
    <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasExampleLabel">Tranzactii</h5>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <!-- OffCanvas: Transaction body  -->
    <div class="offcanvas-body">
        <small class="card-text">Ce operatiune doresti sa efectuezi?</small>
        <!-- Transaction Type Dropdown List -->
        <select name="transact-type" class="form-control mt-2 mb-4" id="transact-type">
            <option value="">- Alege Tipul de Tranzactie -</option>
            <option value="Payment">Plata</option>
            <option value="Transfer">Transfer</option>
            <option value="Deposit">Depunere</option>
            <option value="Withdrawal">Retragere</option>
        </select>
        <!-- End Transaction Type Dropdown List -->


        <!--  Payments Form Card -->
        <c:import url="components/transact_forms/payment_form.jsp"/>
        <!--  Transfer Form Card -->
        <c:import url="components/transact_forms/transfer_form.jsp"/>
        <!--  Deposit Form Card -->
        <c:import url="components/transact_forms/deposit_form.jsp"/>
        <!--  Withdraw Form Card -->
        <c:import url="components/transact_forms/withdraw_form.jsp"/>


    </div>
    <!-- End OffCanvas: Transaction body  -->
</div>
<!-- End of Start Transact OffCanvas  -->