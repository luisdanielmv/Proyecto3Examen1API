package com.ucenfotec.proyecto3examen1.proyecto3examen1.web;

import com.ucenfotec.proyecto3examen1.proyecto3examen1.domain.Tag;
import com.ucenfotec.proyecto3examen1.proyecto3examen1.service.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/tag")
public class TagController {

    private final TagService tagService;
    public TagController(TagService tagService){
        this.tagService = tagService;
    }

    @GetMapping
    public List<Tag> getAll() {
        return tagService.findAll();
    }

    @GetMapping("/get-by-id/{taskId}")
    public Tag getByIdPath(@PathVariable Long taskId) {
        return tagService.findById(taskId);
    }

    @PostMapping()
    public Tag postTag(@RequestBody Tag tag) {
        return tagService.save(tag);
    }

    @PutMapping()
    public Tag putTodo(@RequestBody Tag tag) {
        return tagService.update(tag);
    }

    @PostMapping("/list")
    public List<Tag> postTagList(@RequestBody List<Tag> tagList) {
        for (int i = 0; i < tagList.size(); i++) {
            tagList.set(i, tagService.save(tagList.get(i)));
        }
        return tagList;
    }
}
