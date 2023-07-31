package com.parishjain.EcommerceWebApp.controller;

import com.parishjain.EcommerceWebApp.models.User;
import com.parishjain.EcommerceWebApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/register")
    public String addUser(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @PostMapping(value = "/register")
    public String addUser(@ModelAttribute("user") User user){
       userService.addUser(user);
        return "login";
    }

    @GetMapping(value = "/login")
    public String login(){
        return "/login";
    }
    @PostMapping(value = "/login")
    // In the HTML form, the name attribute is used to identify the input fields when the form is submitted.
    // When the user enters their email in the email input field and submits the form,
    // the browser will send the form data as part of the request parameters to the serv
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password){

        Boolean status = userService.loginUser(email,password);
        if(status){
            return "redirect:/shop";
        }
        else return "/login";
    }




}
