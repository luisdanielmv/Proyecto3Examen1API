package com.ucenfotec.proyecto3examen1.proyecto3examen1.service;

import com.ucenfotec.proyecto3examen1.proyecto3examen1.domain.Post;
import com.ucenfotec.proyecto3examen1.proyecto3examen1.domain.Tag;
import com.ucenfotec.proyecto3examen1.proyecto3examen1.domain.User;
import com.ucenfotec.proyecto3examen1.proyecto3examen1.repository.PostRepository;
import com.ucenfotec.proyecto3examen1.proyecto3examen1.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional(readOnly = true)
    public List<Post> findAll() {
        return  postRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Post findById(Long idTask) {
        Optional<Post> post =  postRepository.findById(idTask);
        return post.isPresent() ? post.get() : null;
    }

    @Transactional(readOnly = true)
    public Post findByStatus(String status) {
        Optional<Post> post =  postRepository.findByStatus(status);
        return post.isPresent() ? post.get() : null;
    }

    @Transactional
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Transactional
    public Post update(Post post) {
        boolean isPresent = postRepository.findById(post.getId()).isPresent();
        return isPresent ? postRepository.save(post) : null;
    }

    public List<Post> findByOwnerId(Long id) {
        return postRepository.findByOwnerIdInOrderByIdDesc(id);
    }

    public List<Post> findByUserPreferences(Set<Tag> preferences) {
        return postRepository.findByTagsInOrderByIdDesc(preferences);
    }

    public List<Post> findByLikers(User user) {
        return postRepository.findByLikersInOrderByIdDesc(user);
    }
}
