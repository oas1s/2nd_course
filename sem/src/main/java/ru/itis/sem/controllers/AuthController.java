package ru.itis.sem.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.sem.services.AuthCheckService;

@Controller
public class AuthController {

    @Autowired
    private AuthCheckService authCheckService;

    @GetMapping("/auth")
    public String authPage(@RequestParam String uuid, Authentication authentication, Model model){
        boolean status = authCheckService.checkAuth(authentication,uuid);
        model.addAttribute("status",status);
        return "auth";
    }
}
