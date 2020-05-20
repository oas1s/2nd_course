package ru.itis.sem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import javax.validation.constraints.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import ru.itis.sem.dto.CaptchaResponseDto;
import ru.itis.sem.dto.SignUpDto;
import ru.itis.sem.models.User;
import ru.itis.sem.repositories.UserRepository;
import ru.itis.sem.services.UserService;
import ru.itis.sem.utills.ControllerUtils;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@Controller
public class SignUpController {
    private final static String CAPTCHA_URL = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";

    @Value("${recaptcha.secret}")
    private String secret;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/signUp")
    public String getSignUpPage(Model model){
//        boolean ok = true;
//        model.addAttribute("ok",ok);
        model.addAttribute("signUpDto",new SignUpDto());
        return "sign_up";
    }

    @PostMapping("/signUp")
    public String signUp(@RequestParam("g-recaptcha-response") String captchaResponce, @Valid SignUpDto signUpDto, BindingResult bindingResult, Model model) {
        String url = String.format(CAPTCHA_URL, secret, captchaResponce);
        CaptchaResponseDto response = restTemplate.postForObject(url, Collections.emptyList(), CaptchaResponseDto.class);
        if (response.isSuccess()) {
//        boolean ok = true;
            if (bindingResult.hasErrors()) {
//            ok = false;
//            model.addAttribute("ok",ok);
                return "sign_up";
            } else {
                userService.register(signUpDto);
                return "redirect:/signIn";
            }
        } else {
            model.addAttribute("captcha","SEND A CAPTCHA");
            return "sign_up";
        }
    }
}
