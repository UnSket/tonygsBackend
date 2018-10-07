package ru.tsvetkov.dev.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.tsvetkov.dev.entity.Photo;
import ru.tsvetkov.dev.entity.specification.PhotoSpecification;
import ru.tsvetkov.dev.repository.PhotoRepository;
import ru.tsvetkov.dev.service.PhotoService;

@Service
public class PhotoServiceImpl implements PhotoService {
    private final PhotoRepository photoRepository;

    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public Page<Photo> getAll(Pageable pageable, String q) {
        Specification<Photo> specification = PhotoSpecification.nameLikeQIgnoreCase(q);
        return photoRepository.findAll(specification, pageable);
    }
}
