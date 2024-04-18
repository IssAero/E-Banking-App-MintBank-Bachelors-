//Get Transaction Type
const transactType = document.querySelector("#transact-type");

//Get Transaction Forms
const paymentCard = document.querySelector(".payment-card");
const transferCard = document.querySelector(".transfer-card");
const depositCard = document.querySelector(".deposit-card");

transactType.addEventListener("change",function(){

    //Check for Transaction Type and Display Form:
    switch(transactType.value){
        case "Payment":
            paymentCard.style.display = "block";
            paymentCard.nextElementSibling.style.display = "none";
        break;

        case "Transfer":
            transferCard.previousElementSibling.style.display = "none";
            transferCard.style.display = "block";
            transferCard.nextElementSibling.style.display = "none";
        break;
    }
});


