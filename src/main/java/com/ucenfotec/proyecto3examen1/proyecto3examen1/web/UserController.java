package com.ucenfotec.proyecto3examen1.proyecto3examen1.web;

import com.ucenfotec.proyecto3examen1.proyecto3examen1.domain.User;
import com.ucenfotec.proyecto3examen1.proyecto3examen1.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/get-by-id/{taskId}")
    public User getByIdPath(@PathVariable Long taskId) {
        return userService.findById(taskId);
    }

    @GetMapping("/get-by-status")
    public User getByStatusQuery(@RequestParam("status") String taskStatus) {
        return userService.findByStatus(taskStatus);
    }

    @PostMapping()
    public User postUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping()
    public User putUser(@RequestBody User user) {
        return userService.update(user);
    }

    @PutMapping("/update-status/{taskId}")
    public User updateStatus(@PathVariable Long taskId, @RequestParam String status) {
        User tdt = userService.findById(taskId);
        tdt.setStatus(status);
        return userService.update(tdt);
    }

    @PostMapping("/authenticate")
    public User authenticateUser(@RequestBody User user) {
        User authUser = userService.findByNickName(user.getNickName());
        return authUser;
    }
}
