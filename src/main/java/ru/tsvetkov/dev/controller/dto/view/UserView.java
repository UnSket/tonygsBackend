package ru.tsvetkov.dev.controller.dto.view;

import lombok.Builder;
import lombok.Data;
import ru.tsvetkov.dev.entity.User;

import java.util.Optional;

@Data
@Builder
public class UserView {
    private Long id;
    private String fullName;
    private String photoPath;

    public static UserView buildInfoFrom(User entity) {
        return Optional.ofNullable(entity).map(user -> {
            return UserView.builder()
                    .id(user.getId())
                    .fullName(user.getFullName())
                    .photoPath(user.getPhoto())
                    .build();
        }).orElse(null);
    }
}
