package ru.itis.sem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.sem.models.User;

@Data
@Builder
public class MessageDto {
    public MessageDto(String text, UserDto from) {
        this.text = text;
        this.from = from;
    }

    public MessageDto() {
    }

    public MessageDto(String text) {
        this.text = text;
    }

    public MessageDto(UserDto from) {
        this.from = from;
    }

    private String text;
    private UserDto from;
}
