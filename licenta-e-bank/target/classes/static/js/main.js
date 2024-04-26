//Get Transaction Type
const transactType = document.querySelector("#transact-type");

//Get Transaction Forms
const paymentCard = document.querySelector(".payment-card");
const transferCard = document.querySelector(".transfer-card");
const depositCard = document.querySelector(".deposit-card");
const withdrawCard = document.querySelector(".withdraw-card");


//Check for Transaction Type Event Listener:
transactType.addEventListener("change",function(){

    //Check for Transaction Type and Display Form:
    switch(transactType.value){
        case "Payment":
            paymentCard.style.display = "block";
            paymentCard.nextElementSibling.style.display = "none";
            depositCard.style.display = "none";
            withdrawCard.style.display = "none";
        break;

        case "Transfer":
            transferCard.previousElementSibling.style.display = "none";
            transferCard.style.display = "block";
            transferCard.nextElementSibling.style.display = "none";
            withdrawCard.style.display = "none";
        break;

        case "Deposit":
            paymentCard.style.display = "none";
            depositCard.previousElementSibling.style.display = "none";
            depositCard.style.display = "block";
            depositCard.nextElementSibling.style.display = "none";
        break;

        case "Withdrawal":
            transferCard.style.display = "none";
            withdrawCard.previousElementSibling.style.display = "none";
            withdrawCard.style.display = "block";
            paymentCard.style.display = "none";
        break;
    }
    //End Check for Transaction Type and Display Form:


});
// End Check for Transaction Type Event Listener:



