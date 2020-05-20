package ru.itis.sem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.sem.models.Post;
import ru.itis.sem.models.Skill;

import java.util.List;

public interface SkillsRepository extends JpaRepository<Skill,Long> {
    List<Skill> findAllBySkill(String skill);
}
