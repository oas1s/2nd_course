package ru.itis.sem.services;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.itis.sem.dto.SignUpDto;

@Service
public interface UserService {
    public void register(SignUpDto signUpDto);
}
