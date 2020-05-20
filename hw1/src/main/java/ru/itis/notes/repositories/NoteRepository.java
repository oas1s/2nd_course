package ru.itis.notes.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.itis.notes.entity.NoteEntity;

import java.util.List;


public interface NoteRepository extends JpaRepository<NoteEntity, Long> {

    Page<NoteEntity> findAllByNameStartingWith(String name, Pageable pageable);

    Page<NoteEntity> findAll(Pageable pageable);
}
