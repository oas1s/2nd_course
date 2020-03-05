package ru.itis.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.itis.notes.entity.NoteEntity;
import ru.itis.notes.models.Note;
import ru.itis.notes.repositories.NoteRepository;
import ru.itis.notes.service.NoteService;

@Component
public class AppCheck implements CommandLineRunner {

    @Autowired
    private NoteService noteService;

    @Override
    public void run(String... args) throws Exception {
        NoteEntity note = new NoteEntity().builder().id(1L).name("dasdasdas").text("adsasdasd").build();
        noteService.addNote(note);
//        System.out.println(noteService.findAll());
        System.out.println(noteService.findByName(note.getName()));
    }
}
