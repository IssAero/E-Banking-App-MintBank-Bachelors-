<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Card: Transfer Card -->
<div class="card transfer-card">
    <!-- Card Body -->
    <div class="card-body">

    <!-- Transfer Form -->
    <form action="/transact/transfer" method="POST">
        <!-- Form Group -->
        <div class="form-group mb-3">
            <label for="">Cat vrei sa transferi?</label>
            <input type="text" name="transfer_amount" class="form-control" placeholder="Introdu suma">
        </div>
        <!-- End Form Group -->

        <!-- Form Group -->
        <div class="form-group mb-3">
            <label for="">Alege contul</label>
            <!-- Select account option -->
            <select name="transfer_from" class="form-control my-2" id="">
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
        <div class="form-group mb-3">
            <label for="">Alege contul</label>
            <!-- Select account option -->
            <select name="transfer_to" class="form-control my-2" id="">
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
        <div class="form-group mb-3">
            <label for="">Detalii de transfer</label>
            <input type="text" name="details" class="form-control" placeholder="Introdu aici detaliile de transfer">
        </div>
        <!-- End Form Group -->

        <!-- Form Group -->
        <div class="form-group" align="center">
            <button id="transact-btn" class="btn btn-lg mt-4 py-1" align="center">Continua</button>
        </div>
        <!-- End Form Group -->
    </form>
    <!-- End of Transfer Form -->

    </div>
    <!-- End Card Body -->
</div>
<!-- End Card: Transfer Card -->