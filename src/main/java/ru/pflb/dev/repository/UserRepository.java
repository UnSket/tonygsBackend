package ru.pflb.dev.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.pflb.dev.entity.User;

import java.util.Optional;

/**
 * Created by Danila on 27.03.2018.
 */
public interface UserRepository  extends JpaRepository<User, Long> {
    Page<User> findAll(Pageable pageable);

    Optional<User> findOneByLoginIgnoreCase(String usernameOrEmail);
}
