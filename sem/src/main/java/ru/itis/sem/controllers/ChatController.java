package ru.itis.sem.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.sem.dto.UserDto;
import ru.itis.sem.models.User;
import ru.itis.sem.security.details.UserDetailsImpl;


@Controller
public class ChatController {
    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/chatPage")
    public String getIndexPage(Authentication authentication, Model model) throws JsonProcessingException {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        UserDto userDto = UserDto.builder().id(user.getId()).name(user.getName()).build();
        String userDtoJson = objectMapper.writeValueAsString(userDto);
        model.addAttribute("userId", userDtoJson);
        return "chat_page";
    }
}
