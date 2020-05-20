package ru.itis.sem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itis.sem.models.State;
import ru.itis.sem.models.User;
import ru.itis.sem.repositories.UserRepository;
import ru.itis.sem.security.details.UserDetailsImpl;

@Service
public class AuthCheckServiceImpl implements AuthCheckService {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean checkAuth(Authentication authentication, String uuid) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        if (user.getUuid().equals(uuid)){
            userRepository.updateUserState(State.CONFIRMED,user.getId());
            System.out.println("one user state confirmed");
            return true;
        } else{
            System.out.println("someone try to fake confirm");
            return false;
        }
    }
}
