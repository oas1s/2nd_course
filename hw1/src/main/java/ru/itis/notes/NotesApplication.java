package ru.itis.notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itis.notes.entity.NoteEntity;
import ru.itis.notes.repositories.NoteRepository;
import ru.itis.notes.service.NoteService;

@SpringBootApplication
public class NotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotesApplication.class, args);
    }

}
