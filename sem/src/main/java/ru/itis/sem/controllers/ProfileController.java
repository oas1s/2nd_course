package ru.itis.sem.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.sem.models.Post;
import ru.itis.sem.models.User;
import ru.itis.sem.repositories.UserRepository;
import ru.itis.sem.utills.UserConverterUtill;

import java.util.List;
import java.util.Optional;

@Controller
public class ProfileController  {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/profile")
    public String getProfilePage(Authentication authentication, Model model){
       User u = UserConverterUtill.convertToUser(authentication);
        Long userId = u.getId();
       User currentUser =  userRepository.findById(userId).get();
        model.addAttribute("user",currentUser);
       model.addAttribute("posts",currentUser.getPosts());
        return "profile";
    }
}
