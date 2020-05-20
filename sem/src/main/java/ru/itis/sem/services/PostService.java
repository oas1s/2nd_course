package ru.itis.sem.services;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itis.sem.models.Post;

@Service
public interface PostService {
    void savePost(Authentication authentication, Post post);
}
