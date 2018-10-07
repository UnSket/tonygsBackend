package ru.tsvetkov.dev.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import ru.tsvetkov.dev.entity.Role;

import java.util.Collection;
import java.util.Collections;

@Getter
public class LoggedUser extends User {
    private final Long id;
    private final Role role;
    public LoggedUser(Long id, String username, String password, Role role) {
        super(username, password, Collections.singletonList(new SimpleGrantedAuthority(role.getName())));
        this.id = id;
        this.role = role;
    }
}
