package ru.itis.sem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.itis.sem.dto.SignUpDto;
import ru.itis.sem.models.Role;
import ru.itis.sem.models.State;
import ru.itis.sem.models.User;
import ru.itis.sem.repositories.UserRepository;
import ru.itis.sem.utills.ControllerUtils;

import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    MailSenderService mailSenderService;

    @Override
    public void register(SignUpDto signUpDto) {

        User user = User.builder()
                .email(signUpDto.getEmail())
                .password(passwordEncoder.encode(signUpDto.getPassword()))
                .name(signUpDto.name)
                .role(Role.USER)
                .state(State.NOT_CONFIRMED)
                .uuid(UUID.randomUUID().toString())
                .build();
        mailSenderService.sendMail(user);
        userRepository.save(user);
    }
}
