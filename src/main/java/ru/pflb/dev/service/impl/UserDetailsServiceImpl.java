package ru.pflb.dev.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pflb.dev.entity.Role;
import ru.pflb.dev.repository.UserRepository;
import ru.pflb.dev.security.LoggedUser;

import java.util.Collections;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    //get user from the database, via Hibernate
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(final String usernameOrEmail) throws UsernameNotFoundException {
        logger.info("loadUserByUsername: " + usernameOrEmail);
        return userRepository.findOneByLoginIgnoreCase(usernameOrEmail).map(user -> {
            return buildUserForAuthentication(user, user.getRole());
        }).orElse(null);
    }

    /**
     * Конвертация User сущности приложения в User сущность org.springframework.security.core.userdetails.User
     *
     * @param user        Пользователь приложения
     * @param role   Права пользователя
     * @return Пользователь системы безопасности org.springframework.security.core.userdetails.User
     */
    private LoggedUser buildUserForAuthentication(ru.pflb.dev.entity.User user,
                                            Role role) {
        return new LoggedUser(user.getId(), user.getLogin(), user.getPassword(), role);
    }

}
