package ru.itis.sem.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.sem.models.User;
import ru.itis.sem.repositories.UserRepository;
import ru.itis.sem.services.UserUpdateService;
import ru.itis.sem.utills.UserConverterUtill;

@Controller
public class EditProfileController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserUpdateService userUpdateService;

    @GetMapping("/edit")
    public String getEditPage(){
        return "edit";
    }

    @PostMapping("/edit")
    public String editPage(User user, Authentication authentication){
        User userCheck = userUpdateService.updateUser(user,authentication);
        System.out.println(userCheck);
        return "redirect:/profile";
    }
}
