<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Card: Withdraw Card -->
<div class="card withdraw-card">
    <!-- Card Body -->
    <div class="card-body">

        <!-- Form Group -->
        <form action="/transact/withdraw" method="POST">
        <div class="form-group mb-3">
            <label for="">Cat vrei sa retragi?</label>
            <input type="text" name="withdraw_amount" class="form-control" placeholder="Introdu suma">
        </div>
        <!-- End Form Group -->

        <!-- Form Group -->
        <div class="form-group mb-3">
            <label for="">Alege contul</label>
            <!-- Select account option -->
            <select name="account_id" class="form-control my-2" id="">
                <option value="">- Alege Contul -</option>
                <c:if test="${userAccounts != null}">
                    <c:forEach items="${userAccounts}" var="selectAccount">
                        <option value="${selectAccount.account_id}">${selectAccount.account_name}</option>
                    </c:forEach>
                </c:if>
            </select>
            <!-- End Select account option -->
        </div>
        <!-- End Form Group -->

        <!-- Form Group -->
        <div class="form-group" align="center">
            <button id="transact-btn" class="btn btn-lg mt-4 py-1" align="center">Continua</button>
        </div>
        <!-- End Form Group -->
        </form>

    </div>
    <!-- End Card Body -->
</div>
<!-- End Card: Withdraw Card -->