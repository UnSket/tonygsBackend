package ru.tsvetkov.dev.entity.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.tsvetkov.dev.entity.Music;
import ru.tsvetkov.dev.entity.Music_;
import ru.tsvetkov.dev.entity.Photo;
import ru.tsvetkov.dev.entity.Photo_;

public class PhotoSpecification {
    public static Specification<Photo> nameLikeQIgnoreCase(String q) {
        return (root, criteriaQuery, cb) -> cb.or(cb.like(cb.lower(root.get(Photo_.description)), ("%" + q + "%").toLowerCase()));
    }
}
