package com.licentaebank.controllers;

import com.licentaebank.models.Account;
import com.licentaebank.models.User;
import com.licentaebank.repository.AccountRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/app")
public class AppController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/dashboard")
    public ModelAndView getDashboard(HttpSession session){
        ModelAndView getDashboardPage = new ModelAndView("dashboard");

        //Get details of logged-in user:
        User user = (User)session.getAttribute("user");

         //Get the accounts of the logged-in user:
        List<Account> getUserAccounts = accountRepository.getUserAccountsById(user.getUser_id());

         //Get Balance:
        BigDecimal totalAccountsBalance = accountRepository.getTotalBalance(user.getUser_id());

        // Set Objects:
        getDashboardPage.addObject("userAccounts", getUserAccounts);
        getDashboardPage.addObject("totalBalance", totalAccountsBalance);

        return getDashboardPage;
    }
}
