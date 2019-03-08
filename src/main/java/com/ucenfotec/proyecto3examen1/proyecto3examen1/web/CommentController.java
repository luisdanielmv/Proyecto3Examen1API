package com.ucenfotec.proyecto3examen1.proyecto3examen1.web;

import com.ucenfotec.proyecto3examen1.proyecto3examen1.domain.Comment;
import com.ucenfotec.proyecto3examen1.proyecto3examen1.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAll() {
        return commentService.findAll();
    }

    @GetMapping("/get-by-id/{taskId}")
    public Comment getByIdPath(@PathVariable Long taskId) {
        return commentService.findById(taskId);
    }

    @PostMapping()
    public Comment commentTodo(@RequestBody Comment comment) {
        return commentService.save(comment);
    }

    @PutMapping()
    public Comment putTodo(@RequestBody Comment comment) {
        return commentService.update(comment);
    }

}
