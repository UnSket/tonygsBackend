package ru.tsvetkov.dev.controller;

/**
 * Created by Danila on 02.01.2018.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ru.tsvetkov.dev.entity.User;
import ru.tsvetkov.dev.security.SecurityUtils;
import ru.tsvetkov.dev.service.UserService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@Secured(value = {"ROLE_ADMIN"})
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/user")
    public ResponseEntity editUser(@RequestBody User user) {
        logger.debug("REST request to edit user {}", user);
        userService.saveUser(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/user")
    public ResponseEntity createUser(@RequestBody User user) {
        logger.debug("REST request to create user {}", user);

        return ResponseEntity.ok(userService.saveUser(user));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        logger.debug("REST request to delete user id {} ", id);
        userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity getUsers(Pageable page){
        logger.debug("REST request to get users");

        return ResponseEntity.ok(userService.findAll(page));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUser(@PathVariable Long id){
        logger.debug("REST request to get users");

        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/account")
    public ResponseEntity getCurrentUser(){
        logger.debug("REST request to get users");

        return ResponseEntity.ok(userService.findById(SecurityUtils.getCurrentUser().getId()));
    }


}