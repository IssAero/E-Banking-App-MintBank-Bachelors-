package com.licentaebank.controllers;

import com.licentaebank.helpers.HTML;
import com.licentaebank.helpers.Token;
import com.licentaebank.mailMessenger.MailMessenger;
import com.licentaebank.models.User;
import com.licentaebank.repository.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public ModelAndView getRegister(){
        ModelAndView getRegisterPage = new ModelAndView("register");
        System.out.println("In Register Page Controller");
        getRegisterPage.addObject("PageTitle", "Register");
        return getRegisterPage;
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute("registerUser")User user,
                                 BindingResult result,
                                 @RequestParam("last_name") String last_name,
                                 @RequestParam("first_name")String first_name,
                                 @RequestParam("email")String email,
                                 @RequestParam("password")String password,
                                 @RequestParam("confirm_password")String confirm_password) throws MessagingException {


        ModelAndView registrationPage = new ModelAndView("register");

        // Check For Errors:
        if(result.hasErrors() && confirm_password.isEmpty()){
            registrationPage.addObject("confirm_pass", "Campul acesta nu poate sa fie gol");
            return registrationPage;
        }


        // TODO: CHECK FOR PASSWORD MATCH:
        if(!password.equals(confirm_password)){
            registrationPage.addObject("passwordMismatch", "Parolele nu sunt identice");
            return registrationPage;
        }

        // TODO: GET TOKEN STRING:
        String token = Token.generateToken();

        // TODO: GENERATE RANDOM CODE:
        Random rand = new Random();
        int bound = 856;
        int code = bound * rand.nextInt(bound);


        // TODO: GET EMAIL HTML BODY:
        String emailBody = HTML.htmlEmailTemplate(token, code);

        // TODO: HASH PASSWORD:
        String hashed_password = BCrypt.hashpw(password, BCrypt.gensalt());

        // TODO: REGISTER USER:
        userRepository.registerUser(first_name, last_name, email, hashed_password, token, code);

        // TODO: SEND EMAIL NOTIFICATION:
        MailMessenger.htmlEmailMessenger("no-reply@evermint.com", email, "Confirma-ti contul", emailBody);

        // TODO: RETURN TO REGISTER PAGE:
        String successMessage = "Contul a fost inregistrat cu success. Verifica-ti adresa de email pentru a-ti confirma contul";
        registrationPage.addObject("success", successMessage);
        return registrationPage;
    }

}
