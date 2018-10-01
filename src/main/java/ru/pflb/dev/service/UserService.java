package ru.pflb.dev.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.pflb.dev.entity.User;

import java.util.List;

/**
 * Created by Danila on 02.01.2018.
 */
public interface UserService {

    Page<User> findAll(Pageable page);

    User saveUser(User user);

    void deleteUser(Long id);

    User findById(Long id);
}
