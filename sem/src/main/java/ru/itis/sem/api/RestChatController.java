package ru.itis.sem.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.sem.dto.UserDto;
import ru.itis.sem.models.User;
import ru.itis.sem.security.details.UserDetailsImpl;

@RestController
public class RestChatController {

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("api/chatPage")
    public ResponseEntity getIndexPage(Authentication authentication, Model model) throws JsonProcessingException {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        UserDto userDto = UserDto.builder().id(user.getId()).name(user.getName()).build();
        String userDtoJson = objectMapper.writeValueAsString(userDto);
        return ResponseEntity.ok().build();
    }
}
