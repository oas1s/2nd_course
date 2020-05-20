package ru.itis.sem.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.sem.models.Post;
import ru.itis.sem.models.User;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findAllByUser_Id(Long user_id);
}
