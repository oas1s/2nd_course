package ru.itis.sem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.itis.sem.dto.CaptchaResponseDto;
import ru.itis.sem.dto.SignUpDto;
import ru.itis.sem.repositories.UserRepository;
import ru.itis.sem.services.UserService;

import javax.validation.Valid;
import java.util.Collections;

@RestController
public class RestSignUpController {
    private final static String CAPTCHA_URL = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";

    @Value("${recaptcha.secret}")
    private String secret;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    RestTemplate restTemplate;


    @PostMapping("api/signUp")
    public ResponseEntity signUp(@RequestParam("g-recaptcha-response") String captchaResponce, @Valid SignUpDto signUpDto, BindingResult bindingResult, Model model) {
        String url = String.format(CAPTCHA_URL, secret, captchaResponce);
        CaptchaResponseDto response = restTemplate.postForObject(url, Collections.emptyList(), CaptchaResponseDto.class);
        if (response.isSuccess()) {
            if (bindingResult.hasErrors()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            } else {
                userService.register(signUpDto);
              return ResponseEntity.ok().build();
            }
        } else {
            model.addAttribute("captcha","SEND A CAPTCHA");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
