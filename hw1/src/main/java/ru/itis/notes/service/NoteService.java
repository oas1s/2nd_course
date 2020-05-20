package ru.itis.notes.service;

import javafx.scene.control.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<NoteEntity> findallPag(Pageable pagination) {
        return noteRepository.findAll(pagination);
    }

    public Page<NoteEntity> findByName(String name, Pageable pageable) {
        return noteRepository.findAllByNameStartingWith(name, pageable);
    }
}
