package ru.tsvetkov.dev.entity.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.tsvetkov.dev.entity.Music;
import ru.tsvetkov.dev.entity.Music_;

public class MusicSpecification {
    public static Specification<Music> nameLikeQIgnoreCase(String q) {
        return (root, criteriaQuery, cb) -> cb.or(cb.like(cb.lower(root.get(Music_.name)), ("%" + q + "%").toLowerCase()),
                cb.like(cb.lower(root.get(Music_.description)), ("%" + q + "%").toLowerCase()));
    }
}
