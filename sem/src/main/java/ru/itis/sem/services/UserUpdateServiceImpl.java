package ru.itis.sem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itis.sem.models.User;
import ru.itis.sem.repositories.UserRepository;
import ru.itis.sem.utills.UserConverterUtill;

@Service
public class UserUpdateServiceImpl implements UserUpdateService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User updateUser(User user, Authentication authentication) {
        User authUser = UserConverterUtill.convertToUser(authentication);
        user.setId(authUser.getId());
        if (user.getName() == null){
            user.setName(authUser.getName());
        }
        if (user.getUuid() == null){
            user.setUuid(authUser.getUuid());
        }
        if (user.getEmail() == null){
            user.setEmail(authUser.getEmail());
        }
        if (user.getPassword() == null){
            user.setPassword(authUser.getPassword());
        }
        if (user.getRole() == null){
            user.setRole(authUser.getRole());
        }
        if (user.getState() == null){
            user.setState(authUser.getState());
        }
        if (user.getEducation() == null){
            user.setEducation(authUser.getEducation());
        }
        if (user.getJob() == null){
            user.setJob(authUser.getJob());
        }
        if (user.getExperience() == null){
            user.setExperience(authUser.getExperience());
        }
        if (user.getCountry() == null){
            user.setCountry(authUser.getCountry());
        }
        return userRepository.save(user);
    }
}
