package ru.tsvetkov.dev.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.tsvetkov.dev.entity.Music;
import ru.tsvetkov.dev.entity.specification.MusicSpecification;
import ru.tsvetkov.dev.repository.MusicRepository;
import ru.tsvetkov.dev.service.MusicService;

@Service
public class MusicServiceImpl implements MusicService {
    private final MusicRepository musicRepository;

    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public Page<Music> getAll(Pageable pageable, String q) {
        Specification<Music> specification = MusicSpecification.nameLikeQIgnoreCase(q);
        return musicRepository.findAll(specification, pageable);
    }
}
