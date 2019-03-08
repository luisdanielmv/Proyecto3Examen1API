package com.ucenfotec.proyecto3examen1.proyecto3examen1.service;

import com.ucenfotec.proyecto3examen1.proyecto3examen1.domain.User;
import com.ucenfotec.proyecto3examen1.proyecto3examen1.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return  userRepository.findAll();
    }
    @Transactional(readOnly = true)
    public User findById(Long idTask) {
        Optional<User> user =  userRepository.findById(idTask);
        return user.isPresent() ? user.get() : null;
    }

    @Transactional(readOnly = true)
    public User findByStatus(String status) {
        Optional<User> user =  userRepository.findByStatus(status);
        return user.isPresent() ? user.get() : null;
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User update(User user) {
        boolean isPresent = userRepository.findById(user.getId()).isPresent();
        return isPresent ? userRepository.save(user) : null;
    }

    @Transactional(readOnly=true)
    public User findByNickName(String nickName) {
        Optional<User> user =  userRepository.findByNickName(nickName);
        return user.isPresent() ? user.get() : null;
    }
}
