package ru.itis.sem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itis.sem.models.Post;
import ru.itis.sem.repositories.PostRepository;
import ru.itis.sem.utills.UserConverterUtill;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public void savePost(Authentication authentication, Post post) {
        post.setUser(UserConverterUtill.convertToUser(authentication));
        postRepository.save(post);
    }
}
