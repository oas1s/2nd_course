package ru.itis.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.notes.entity.NoteEntity;
import ru.itis.notes.repositories.NoteRepository;

import java.util.List;

@Component
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public void addNote(NoteEntity noteEntity) {
        noteRepository.save(noteEntity);
    }

    public List<NoteEntity> findAll() {
        return noteRepository.findAll();
    }

    public List<NoteEntity> findByName(String name) {
        return noteRepository.findAllByNameStartingWith(name);
    }
}
