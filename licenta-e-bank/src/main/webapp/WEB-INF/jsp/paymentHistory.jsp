<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="shortcut icon" href="../images/mint-leaves.png"/>
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
        <div class="container my-4">
            <!-- Card: Transaction History Card -->
            <div class="card transaction-history">
                <!-- Card Header -->
                <div class="card-header">
                    <i class="fa-regular fa-credit-card me-2" aria-hidden="true"></i> Istoric Plati
                </div>
                <!-- End Card Header -->

                <!-- Card Body -->
                <div class = "container">

                    <c:if test ="${requestScope.payment_history != null}">
                        <!-- Payment History Table -->
                        <table class = "table text-center table-striped">
                            <tr>
                                <th>Plata</th>
                                <th>Cont</th>
                                <th>Beneficiar</th>
                                <th>IBAN Beneficiar</th>
                                <th>Suma</th>
                                <th>Status</th>
                                <th>Cod Status</th>
                                <th>Data</th>
                                <th>Detalii</th>
                            </tr>
                            <!-- Loop Through Payment History Record -->
                            <c:forEach items="${requestScope.payment_history}" var="payments">
                                <tr>
                                    <td>${payments.payment_id}</td>
                                    <td>${payments.account_name}</td>
                                    <td>${payments.beneficiary}</td>
                                    <td>${payments.iban}</td>
                                    <td>${payments.amount} RON</td>
                                    <td>${payments.status}</td>
                                    <td>${payments.reason_code}</td>
                                    <td>${payments.created_at}</td>
                                    <td>${payments.details}</td>
                                </tr>
                            </c:forEach>
                            <!-- End Loop Through Payment History Records -->
                        </table>
                        <!-- End Payment History Table -->
                    </c:if>

                </div>
                <!-- End Card Body -->

            </div>
            <!-- End Card: Transaction History -->
        </div>
        <!-- End Container -->






        <!-- Footer -->
        <c:import url="components/incl/footer.jsp"/>