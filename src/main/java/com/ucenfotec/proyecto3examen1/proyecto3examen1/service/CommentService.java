package com.ucenfotec.proyecto3examen1.proyecto3examen1.service;

import com.ucenfotec.proyecto3examen1.proyecto3examen1.domain.Comment;
import com.ucenfotec.proyecto3examen1.proyecto3examen1.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Transactional(readOnly = true)
    public List<Comment> findAll() {
        return  commentRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Comment findById(Long idTask) {
        Optional<Comment> comment =  commentRepository.findById(idTask);
        return comment.isPresent() ? comment.get() : null;
    }

    @Transactional
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Transactional
    public Comment update(Comment comment) {
        boolean isPresent = commentRepository.findById(comment.getId()).isPresent();
        return isPresent ? commentRepository.save(comment) : null;
    }
}
