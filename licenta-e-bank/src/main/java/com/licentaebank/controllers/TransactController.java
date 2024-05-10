package com.licentaebank.controllers;


import com.licentaebank.models.User;
import com.licentaebank.repository.AccountRepository;
import com.licentaebank.repository.PaymentRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/transact")
public class TransactController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    User user;
    double currentBalance;
    double newBalance;
    int acc_id;

    @PostMapping("/deposit")
    public String deposit(@RequestParam("deposit_amount")String depositAmount,
                          @RequestParam("account_id")String accountID,
                          HttpSession session,
                          RedirectAttributes redirectAttributes){

        //TODO: CHECK FOR EMPTY STRINGS:
        if(depositAmount.isEmpty() || accountID.isEmpty()){
            redirectAttributes.addFlashAttribute("error", "Suma sau contul nu pot sa fie goale.");
            return "redirect:/app/dashboard";
        }

        //TODO: GET LOGGED IN USER:
        user = (User)session.getAttribute("user");

        //TODO: GET CURRENT ACCOUNT BALANCE:
        acc_id = Integer.parseInt(accountID);
        double depositAmountValue = Double.parseDouble(depositAmount);

        //TODO: CHECK IF DEPOSIT AMOUNT IS ZERO:
        if(depositAmountValue == 0){
            redirectAttributes.addFlashAttribute("error", "Suma nu poate sa fie 0 (Zero).");
            return "redirect:/app/dashboard";
        }

        // TODO: CHECK FOR NEGATIVE VALUES:
        if(depositAmountValue < 0){
            redirectAttributes.addFlashAttribute("error", "Nu poti transfera o suma negativa.");
            return "redirect:/app/dashboard";
        }

        //TODO: UPDATE BALANCE:
        currentBalance = accountRepository.getAccountBalance(user.getUser_id(), acc_id);
        newBalance = currentBalance + depositAmountValue;


        // Update account:
        accountRepository.changeAccountBalanceById(newBalance, acc_id);

        redirectAttributes.addFlashAttribute("success", "Ai adaugat fonduri cu success.");
        return "redirect:/app/dashboard";

    }
    // End Deposits:

    @PostMapping("/transfer")
    public String transfer(@RequestParam("transfer_from")String transfer_from,
                           @RequestParam("transfer_to")String transfer_to,
                           @RequestParam("transfer_amount")String transfer_amount,
                           HttpSession session,
                           RedirectAttributes redirectAttributes){

        // TODO: CHECK FOR EMPTY FIELDS:
        if(transfer_from.isEmpty() || transfer_to.isEmpty() || transfer_amount.isEmpty()){
            redirectAttributes.addFlashAttribute("error", "Campurile nu pot fi goale.");
            return "redirect:/app/dashboard";
        }

        // TODO: CONVERT VARIABLES:
        int transferFromId = Integer.parseInt(transfer_from);
        int transferToId = Integer.parseInt(transfer_to);
        double transferAmount = Double.parseDouble(transfer_amount);

        // TODO: CHECK IF TRANSFERRING INTO THE SAME ACCOUNT:
        if(transferFromId == transferToId){
            redirectAttributes.addFlashAttribute("error", "Nu poti sa transferi in acelasi cont.");
            return "redirect:/app/dashboard";
        }

        // TODO: CHECK FOR ZERO VALUES:
        if(transferAmount == 0){
            redirectAttributes.addFlashAttribute("error", "Nu poti transfera 0 RON.");
            return "redirect:/app/dashboard";
        }

        // TODO: CHECK FOR NEGATIVE VALUES:
        if(transferAmount < 0){
            redirectAttributes.addFlashAttribute("error", "Nu poti transfera o suma negativa.");
            return "redirect:/app/dashboard";
        }

        //TODO: GET LOGGED IN USER:
        user = (User)session.getAttribute("user");

        //TODO: GET CURRENT ACCOUNT BALANCE:
        double currentBalanceOfAccountMakingTransfer = accountRepository.getAccountBalance(user.getUser_id(), transferFromId);
        double currentBalanceOfAccountReceivingTransfer = accountRepository.getAccountBalance(user.getUser_id(), transferToId);

        // TODO: CHECK IF ACCOUNT MAKING TRANSFER HAS REQUIRED SUM AVAILABLE:
        if(currentBalanceOfAccountMakingTransfer < transferAmount){
            redirectAttributes.addFlashAttribute("error", "Fonduri insuficiente.");
            return "redirect:/app/dashboard";
        }

        // TODO: SET NEW BALANCE:
        double newBalanceOfAccountMakingTransfer = currentBalanceOfAccountMakingTransfer - transferAmount;
        double newBalanceOfAccountReceivingTransfer = currentBalanceOfAccountReceivingTransfer + transferAmount;

        //CHANGE THE BALANCE OF THE ACCOUNT MAKING THE TRANSFER:
        accountRepository.changeAccountBalanceById(newBalanceOfAccountMakingTransfer, transferFromId);

        //CHANGE THE BALANCE OF THE ACCOUNT RECEIVING THE TRANSFER:
        accountRepository.changeAccountBalanceById(newBalanceOfAccountReceivingTransfer, transferToId);

        redirectAttributes.addFlashAttribute("success", "Felicitari! Suma a fost transferata cu succes.");
        return "redirect:/app/dashboard";
    }
    // End of Transfer Method.

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam("withdraw_amount")String withdrawAmount,
                           @RequestParam("account_id")String accountID,
                           HttpSession session,
                           RedirectAttributes redirectAttributes){

        // TODO: CHECK FOR EMPTY FIELDS:
        if(withdrawAmount.isEmpty() || accountID.isEmpty()){
            redirectAttributes.addFlashAttribute("error", "Suma/Contul nu pot fi goale.");
            return "redirect:/app/dashboard";
        }

        // TODO: CONVERT VARIABLES:
        acc_id = Integer.parseInt(accountID);
        double withdraw_Amount = Double.parseDouble(withdrawAmount);

        // TODO: CHECK FOR ZERO VALUES:
        if(withdraw_Amount == 0){
            redirectAttributes.addFlashAttribute("error", "Nu poti retrage 0 RON.");
            return "redirect:/app/dashboard";
        }

        // TODO: CHECK FOR NEGATIVE VALUES:
        if(withdraw_Amount < 0) {
            redirectAttributes.addFlashAttribute("error", "Nu poti sa retragi o suma negativa.");
            return "redirect:/app/dashboard";
        }

        // TODO: GET LOGGED IN USER:
        user = (User)session.getAttribute("user");

        // TODO: GET CURRENT ACCOUNT BALANCE:
        currentBalance = accountRepository.getAccountBalance(user.getUser_id(), acc_id);

        // TODO: CHECK IF ACCOUNT MAKING TRANSFER HAS REQUIRED SUM AVAILABLE:
        if(currentBalance < withdraw_Amount){
            redirectAttributes.addFlashAttribute("error", "Fonduri insuficiente.");
            return "redirect:/app/dashboard";
        }

        // TODO: SET NEW BALANCE:
        newBalance = currentBalance - withdraw_Amount;

        // TODO: UPDATE ACCOUNT BALANCE:
        accountRepository.changeAccountBalanceById(newBalance, acc_id);

        redirectAttributes.addFlashAttribute("success", "Felicitari! Suma a fost retrasa cu succes .");
        return "redirect:/app/dashboard";
    }
    //END OF WITHDRAW Method.

    @PostMapping("/payment")
    public String payment(@RequestParam("beneficiary")String beneficiary,
                          @RequestParam("account_number")String account_number,
                          @RequestParam("account_id")String account_id,
                          @RequestParam("payment_amount")String payment_amount,
                          @RequestParam("details")String details,
                          HttpSession session,
                          RedirectAttributes redirectAttributes){

        // TODO: CHECK FOR EMPTY VALUES:
        if(beneficiary.isEmpty() || account_number.isEmpty() || account_id.isEmpty() || payment_amount.isEmpty()){
            redirectAttributes.addFlashAttribute("error", "Campurile nu pot sa fie goale.");
            return "redirect:/app/dashboard";
        }

        // TODO: CHECK IF IBAN EXISTS:
        String getIbanInDatabase = accountRepository.getAccountIban(account_number);

        //Check if IBAN exists:
        if (getIbanInDatabase == null) {
            redirectAttributes.addFlashAttribute("error", "Plata nu a putut fi efectuata. IBAN-ul introdus nu exista.");
            return "redirect:/app/dashboard";
        }

        // TODO: CHECK IBAN BALANCE:
        double currentBalanceByIbanInDatabase = accountRepository.getBalanceByIban(getIbanInDatabase);

        // TODO: CONVERT VARIABLES:
        acc_id = Integer.parseInt(account_id);
        double paymentAmount = Double.parseDouble(payment_amount);

        // TODO: CHECK FOR ZERO VALUES:
        if(paymentAmount == 0){
            redirectAttributes.addFlashAttribute("error", "Plata nu a putut fi efectuata. Nu poti plati 0 RON.");
            return "redirect:/app/dashboard";
        }

        // TODO: CHECK FOR NEGATIVE VALUES:
        if(paymentAmount < 0) {
            redirectAttributes.addFlashAttribute("error", "Plata nu a putut fi efectuata. Nu poti plati o suma negativa.");
            return "redirect:/app/dashboard";
        }

        // TODO: GET LOGGED IN USER:
        user = (User)session.getAttribute("user");

        // TODO: GET CURRENT ACCOUNT BALANCE:
        double currentBalanceAccountMakingPayment = accountRepository.getAccountBalance(user.getUser_id(), acc_id);

        // TODO: CHECK IF ACCOUNT MAKING TRANSFER HAS REQUIRED SUM AVAILABLE:
        if(currentBalanceAccountMakingPayment < paymentAmount){
            redirectAttributes.addFlashAttribute("error", "Plata nu a putut fi efectuata. Fonduri insuficiente.");
            return "redirect:/app/dashboard";
        }

        // TODO: MAKE PAYMENT:
        String reason_code = "Plata procesata";
        paymentRepository.makePayment(acc_id, beneficiary, account_number, paymentAmount, "succes",reason_code, details);

        // TODO: SET NEW BALANCE
        double newBalanceAccountMakingPayment = currentBalanceAccountMakingPayment - paymentAmount;
        double newBalanceAccountByIbanInDatabase = currentBalanceByIbanInDatabase + paymentAmount;

        // TODO: UPDATE ACCOUNT
        accountRepository.changeAccountBalanceById(newBalanceAccountMakingPayment, acc_id);
        accountRepository.changeAccountBalanceByIban(newBalanceAccountByIbanInDatabase, account_number);

        redirectAttributes.addFlashAttribute("success", "Felicitari! Plata a fost efectuata cu succes .");
        return "redirect:/app/dashboard";
    }
}
