package ru.itis.sem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.sem.repositories.PostRepository;
import ru.itis.sem.repositories.UserRepository;

@RestController
public class RestUsersController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("api/users")
    public ResponseEntity getPosts(){
        return ResponseEntity.ok( userRepository.findAll());
    }

    @GetMapping("api/users/{id}")
    public ResponseEntity getPostById(@PathVariable Long id){
        return ResponseEntity.ok(userRepository.findById(id));
    }
}
