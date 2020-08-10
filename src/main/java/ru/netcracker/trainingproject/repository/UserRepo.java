package ru.netcracker.trainingproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netcracker.trainingproject.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
