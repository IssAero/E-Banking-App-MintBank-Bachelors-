package com.licentaebank.controllers;


import com.licentaebank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public ModelAndView getIndex(){
        ModelAndView getIndexPage = new ModelAndView("index");
        getIndexPage.addObject("PageTitle", "Home");
        System.out.println("In index Controller");
        return getIndexPage;
    }

    @GetMapping("/error")
    public ModelAndView getError(){
        ModelAndView getErrorPage = new ModelAndView("error");
        System.out.println("In Error Page Controller");
        getErrorPage.addObject("PageTitle", "Error");
        return getErrorPage;
    }

    @GetMapping("/verify")
    public ModelAndView getVerify(@RequestParam("token")String token, @RequestParam("code") String code){
        // Set View:
        ModelAndView getVerifyPage;

        // Get Token in Database:
        String dbToken = userRepository.checkToken(token);
        // Check if Token is Valid:
        if(dbToken == null){
            getVerifyPage = new ModelAndView("error");
            getVerifyPage.addObject("error", "Acest link a expirat. Te rugam sa soliciti altul.");
            return getVerifyPage;
        }
        // End Check if Token is Valid.

        // Update and Verify Account:
        userRepository.verifyUser(token, code);

        getVerifyPage = new ModelAndView("login");

        getVerifyPage.addObject("success", "Contul a fost confirmat, poti continua catre login!");

        System.out.println("In Verify Page Controller");
        return getVerifyPage;
    }
}
