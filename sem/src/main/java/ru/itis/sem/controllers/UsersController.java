package ru.itis.sem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.sem.models.User;
import ru.itis.sem.repositories.UserRepository;
import ru.itis.sem.utills.UserConverterUtill;

import java.util.Optional;

@Controller
public class UsersController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public String getUsersPage(@RequestParam Long userId, Authentication  authentication,Model model){
        User userCheck = UserConverterUtill.convertToUser(authentication);
        if (userCheck.getId() == userId){
            return "redirect:/profile";
        } else {
            User user = userRepository.findById(userId).get();
            model.addAttribute("posts", user.getPosts());
            model.addAttribute("user", user);
            return "users";
        }
    }
}
