package ru.shihaliev.telecom.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shihaliev.telecom.domain.User;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
