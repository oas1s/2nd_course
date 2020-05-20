package ru.itis.sem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.sem.models.Post;
import ru.itis.sem.services.PostService;

@RestController
public class RestPostController {

    @Autowired
    PostService postService;

    @PostMapping("api/addpost")
    public ResponseEntity addPost(Authentication authentication, Post post){
        postService.savePost(authentication,post);
        return ResponseEntity.ok().build();
    }
}
