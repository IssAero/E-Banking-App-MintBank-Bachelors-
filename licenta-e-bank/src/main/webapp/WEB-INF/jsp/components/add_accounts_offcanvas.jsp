<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Offcanvas right form: Accounts form container  -->

<div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
    <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasRightLabel">Conturi</h5>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <!-- Offcanvas Body : Accounts Form Wrapper  -->
    <div class="offcanvas-body">
        <!-- Card: Account Form -->
        <div class="card">
            <!-- Card Body -->
            <div class="card-body">
                <form action="" class="add-account-form"></form>
                <!-- Form Group -->
                <div class="form-group mb-3">
                    <label for=""> Introdu numele contului: </label>
                    <input type="text" name="account_name" class="form-control" placeholder="Scrie aici numele">
                </div>
                <!-- End Form Group -->


                <!-- Form Group -->
                <div class="form-group mb-3 col-5">
                    <label for="">Alege tipul de cont</label>
                    <select name="account_type" class="form_control" id="">
                        <option value=""> - Alege tipul de cont -</option>
                        <option value="Checking">Cont Curent</option>
                        <option value="Savings">Cont Economii</option>
                        <option value="Business">Cont Business</option>
                    </select>
                </div>
                <!-- End Form Group -->

                <!-- Account Button -->
                <div>
                    <button id="accounts-btn" class="btn btn-sm ms-auto" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">
                        <i class="fa-regular fa-credit-card me-2"></i>Adauga cont
                    </button>
                </div>
                <!-- End Account Button -->

            </div>
            <!-- End Card Body -->
        </div>
        <!-- End Card: Account Form -->
    </div>
    <!-- End Offcanvas Body : Accounts Form Wrapper  -->
</div>
<!-- End Offcanvas right form: Accounts form container  -->