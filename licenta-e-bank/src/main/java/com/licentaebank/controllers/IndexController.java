package com.licentaebank.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {


    @GetMapping("/")
    public ModelAndView getIndex(){
        ModelAndView getIndexPage = new ModelAndView("index");
        getIndexPage.addObject("PageTitle", "Home");
        System.out.println("In index Controller");
        return getIndexPage;
    }


    @GetMapping("/login")
    public ModelAndView getLogin(){
        ModelAndView getLoginPage = new ModelAndView("login");
        System.out.println("In Login Page Controller");
        getLoginPage.addObject("PageTitle", "Login");
        return getLoginPage;
    }


    @GetMapping("/error")
    public ModelAndView getError(){
        ModelAndView getErrorPage = new ModelAndView("error");
        System.out.println("In Error Page Controller");
        getErrorPage.addObject("PageTitle", "Error");
        return getErrorPage;
    }

    @GetMapping("/verify")
    public ModelAndView getVerify(){
        ModelAndView getVerifyPage = new ModelAndView("login");
        System.out.println("In Verify Page Controller");
        getVerifyPage.addObject("PageTitle", "Verify");
        return getVerifyPage;
    }
}
