package ru.itis.sem.utills;

import org.springframework.security.core.Authentication;
import ru.itis.sem.models.User;
import ru.itis.sem.security.details.UserDetailsImpl;

public class UserConverterUtill {
    public static User convertToUser(Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return userDetails.getUser();
    }
}
