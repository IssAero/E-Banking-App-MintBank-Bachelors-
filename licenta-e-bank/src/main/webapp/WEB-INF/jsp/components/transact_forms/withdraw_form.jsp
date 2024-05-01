<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Card: Withdraw Card -->
<div class="card withdraw-card">
    <!-- Card Body -->
    <div class="card-body">
        <!-- Form Group -->
        <div class="form-group mb-3">
            <label for="">Cât vrei să retragi?</label>
            <input type="text" name="payment_amount" class="form-control" placeholder="Introdu suma">
        </div>
        <!-- End Form Group -->

        <!-- Form Group -->
        <div class="form-group mb-3">
            <label for="">Alege contul</label>
            <!-- Select account option -->
            <select name="account-type" class="form-control my-2" id="">
                <option value="">- Alege Contul -</option>
            </select>
            <!-- End Select account option -->
        </div>
        <!-- End Form Group -->

        <!-- Form Group -->
        <div class="form-group" align="center">
            <button id="transact-btn" class="btn btn-lg mt-4 py-1" align="center">Continuă</button>
        </div>
        <!-- End Form Group -->
    </div>
    <!-- End Card Body -->
</div>
<!-- End Card: Withdraw Card -->