package com.ucenfotec.proyecto3examen1.proyecto3examen1.repository;

import com.ucenfotec.proyecto3examen1.proyecto3examen1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByStatus(String status);

    Optional<User> findByNickName(String nickName);
}
