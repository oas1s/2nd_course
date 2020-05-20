package ru.itis.sem.services;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itis.sem.models.User;

@Service
public interface UserUpdateService {
    public User updateUser(User user, Authentication authentication);
}
