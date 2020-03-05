package ru.itis.notes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.itis.notes.entity.NoteEntity;

import java.util.List;


public interface NoteRepository extends JpaRepository<NoteEntity, Long> {

    List<NoteEntity> findAllByNameStartingWith(String name);
}
