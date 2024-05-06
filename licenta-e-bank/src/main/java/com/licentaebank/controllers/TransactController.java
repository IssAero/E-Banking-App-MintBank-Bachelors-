package com.licentaebank.controllers;


import com.licentaebank.models.User;
import com.licentaebank.repository.AccountRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/transact")
public class TransactController {

    @Autowired
    private AccountRepository accountRepository;

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
        User user = (User)session.getAttribute("user");

        //TODO: GET CURRENT ACCOUNT BALANCE:
        int acc_id = Integer.parseInt(accountID);

        double depositAmountValue = Double.parseDouble(depositAmount);

        //TODO: CHECK IF DEPOSIT AMOUNT IS ZERO:
        if(depositAmountValue == 0){
            redirectAttributes.addFlashAttribute("error", "Suma nu poate sa fie 0 (Zero).");
            return "redirect:/app/dashboard";
        }

        //TODO: UPDATE BALANCE:
        double currentBalance = accountRepository.getAccountBalance(user.getUser_id(), acc_id);
        double newBalance = currentBalance + depositAmountValue;


        // Update account:
        accountRepository.changeAccountBalanceById(newBalance, acc_id);

        redirectAttributes.addFlashAttribute("success", "Ai adaugat fonduri cu success.");
        return "redirect:/app/dashboard";

    }
}
