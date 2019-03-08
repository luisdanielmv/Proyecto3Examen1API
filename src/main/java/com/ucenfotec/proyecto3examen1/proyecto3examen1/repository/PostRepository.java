package com.ucenfotec.proyecto3examen1.proyecto3examen1.repository;

import com.ucenfotec.proyecto3examen1.proyecto3examen1.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByStatus(String status);

    //List<Post> findByUser_UserId(Long userId);
}
