package com.ucenfotec.proyecto3examen1.proyecto3examen1.repository;

import com.ucenfotec.proyecto3examen1.proyecto3examen1.domain.Post;
import com.ucenfotec.proyecto3examen1.proyecto3examen1.domain.Tag;
import com.ucenfotec.proyecto3examen1.proyecto3examen1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByStatus(String status);

    List<Post> findByOwnerIdInOrderByIdDesc(Long id);

    List<Post> findByTagsInOrderByIdDesc(Set<Tag> preferences);

    List<Post> findByLikersInOrderByIdDesc(User user);

}
