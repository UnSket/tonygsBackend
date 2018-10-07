package ru.tsvetkov.dev.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.tsvetkov.dev.entity.Music;

public interface MusicService {
    Page<Music> getAll(Pageable pageable, String q);
}
