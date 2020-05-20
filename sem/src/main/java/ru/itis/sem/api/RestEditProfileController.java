package ru.itis.sem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.sem.models.User;
import ru.itis.sem.repositories.UserRepository;
import ru.itis.sem.services.UserUpdateService;

@RestController
public class RestEditProfileController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserUpdateService userUpdateService;

    @PostMapping("api/edit")
    public ResponseEntity editPage(User user, Authentication authentication){
        User userCheck = userUpdateService.updateUser(user,authentication);
        System.out.println(userCheck);
       return ResponseEntity.ok().build();
    }
}
