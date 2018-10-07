package ru.tsvetkov.dev.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.tsvetkov.dev.entity.Photo;

public interface PhotoService {

    Page<Photo> getAll(Pageable pageable, String q);
}
