package com.licentaebank.controllers;

import com.licentaebank.helpers.Token;
import com.licentaebank.models.User;
import com.licentaebank.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public ModelAndView getLogin() {
        System.out.println("In Login Page Controller");
        ModelAndView getLoginPage = new ModelAndView("login");
        // Set Token String:
        String token = Token.generateToken();
        // Send Token to View:
        getLoginPage.addObject("token", token);
        getLoginPage.addObject("PageTitle", "Login");
        return getLoginPage;
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        @RequestParam("_token") String token,
                        Model model,
                        HttpSession session) {

        // TODO: VALIDATE INPUT FIELDS / FORM DATA:
        if (email.isEmpty() || email == null || password.isEmpty() || password == null) {
            model.addAttribute("error", "E-mail sau Parola trebuie completate");
            return "login";
        }

        // TODO: CHECK IF EMAIL EXISTS:
        String getEmailInDatabase = userRepository.getUserEmail(email);

        //Check if email exists:
        if (getEmailInDatabase != null) {
            // Get Password in Database:
            String getPasswordInDatabase = userRepository.getUserPassword(getEmailInDatabase);

            // Validate Password:
            if (!BCrypt.checkpw(password, getPasswordInDatabase)) {
                model.addAttribute("error", "E-mail sau parola sunt incorecte");
                return "login";
            }
            // End of Validate Password
        } else {
            model.addAttribute("error", "Adresa de e-mail nu exista. Contacteaza asistenta tehnica.");
            return "error";
        }
        // End Check if email exists:

        // TODO: CHECK IF USER ACCOUNT IS VERIFIED:
        int verified = userRepository.isVerified(getEmailInDatabase);

        // Check if account is verified:
        if (verified != 1) {
            String msg = "Acest cont nu a fost confirmat. Verifica-ti adresa de e-mail.";
            model.addAttribute("error", msg);
            return "login";
        }
        // End check if account is verified.

        // TODO: PROCEED TO LOG THE USER IN:
        User user = userRepository.getUserDetails(getEmailInDatabase);

        // Set Session Attributes:
        session.setAttribute("user", user);
        session.setAttribute("token", token);
        session.setAttribute("authenticated", true);

        return "redirect:/app/dashboard";
    }
    // End authentication method.

    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes){
        session.invalidate();
        redirectAttributes.addFlashAttribute("logged_out", "Te-ai delogat cu succes.");
        return "redirect:/login";
    }
}
