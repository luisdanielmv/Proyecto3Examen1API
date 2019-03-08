package com.ucenfotec.proyecto3examen1.proyecto3examen1.repository;

import com.ucenfotec.proyecto3examen1.proyecto3examen1.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
