package ru.itis.sem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import ru.itis.sem.models.Post;
import ru.itis.sem.models.State;
import ru.itis.sem.models.User;
import ru.itis.sem.repositories.PostRepository;
import ru.itis.sem.repositories.UserRepository;

import java.util.List;

@Component
public class SimpleRunner implements CommandLineRunner {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
//        SimpleMailMessage message = new SimpleMailMessage();
//
//        message.setTo("azatazat835@mail.ru");
//        message.setSubject("Test Simple Email");
//        message.setText("Hello, Im testing Simple Email");
//        javaMailSender.send(message);
//        User user = User.builder().email("aasdddd").password("asdd").state(State.NOT_CONFIRMED).build();
//        userRepository.save(user);
//        userRepository.updateUserState(State.CONFIRMED,22L);

    }
}
