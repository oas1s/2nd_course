package ru.itis.sem.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.sem.models.Post;
import ru.itis.sem.services.PostService;

@Controller
public class PostsController {

    @Autowired
    PostService postService;

    @GetMapping("/addpost")
    public String addPostPage(){
        return "addpost";
    }

    @PostMapping("/addpost")
    public String addPost(Authentication authentication, Post post){
        postService.savePost(authentication,post);
        return "redirect:/profile";
    }
}
