package com.ucenfotec.proyecto3examen1.proyecto3examen1.web;

import com.ucenfotec.proyecto3examen1.proyecto3examen1.domain.Post;
import com.ucenfotec.proyecto3examen1.proyecto3examen1.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAll() {
        return postService.findAll();
    }

    @GetMapping("/get-by-id/{taskId}")
    public Post getByIdPath(@PathVariable Long taskId) {
        return postService.findById(taskId);
    }

    @GetMapping("/get-by-status")
    public Post getByStatusQuery(@RequestParam("status") String taskStatus) {
        return postService.findByStatus(taskStatus);
    }

    @PostMapping()
    public Post postTodo(@RequestBody Post post) {
        return postService.save(post);
    }

    @PutMapping()
    public Post putTodo(@RequestBody Post post) {
        return postService.update(post);
    }

    @PutMapping("/update-status/{taskId}")
    public Post updateStatus(@PathVariable Long taskId, @RequestParam String status) {
        Post tdt = postService.findById(taskId);
        tdt.setStatus(status);
        return postService.update(tdt);
    }

}
