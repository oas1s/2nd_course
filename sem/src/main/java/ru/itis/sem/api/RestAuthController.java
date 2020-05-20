package ru.itis.sem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.sem.services.AuthCheckService;

@RestController
public class RestAuthController {

    @Autowired
    AuthCheckService authCheckService;

    @GetMapping("api/auth")
    public ResponseEntity authPage(@RequestParam String uuid, Authentication authentication, Model model){
        boolean status = authCheckService.checkAuth(authentication,uuid);
        return ResponseEntity.ok().build();
    }
}
