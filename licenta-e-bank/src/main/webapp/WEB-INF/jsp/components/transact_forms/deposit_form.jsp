<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Card: deposit Card -->
<div class="card deposit-card">
    <!-- Card Body -->
    <div class="card-body">

    <form action="/transact/deposit" method="POST" class="deposit-form">
        <!-- Form Group -->
        <div class="form-group mb-3">
            <label for="">Cat doresi sa depui?</label>
            <input type="text" name="deposit_amount" class="form-control" placeholder="Introdu suma">
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
            <button id="" class="btn btn-lg mt-4 py-1 transact-btn" align="center">Continua</button>
        </div>
        <!-- End Form Group -->
    </form>
    <!-- End Deposit Form -->
    </div>
    <!-- End Card Body -->
</div>
<!-- End Card: deposit Card -->