package ru.itis.sem.services;

import org.springframework.security.core.Authentication;

public interface AuthCheckService {
    public boolean checkAuth(Authentication authentication, String uuid);
}
