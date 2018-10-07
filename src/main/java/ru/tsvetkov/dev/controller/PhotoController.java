package ru.tsvetkov.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tsvetkov.dev.entity.Music;
import ru.tsvetkov.dev.entity.Photo;
import ru.tsvetkov.dev.service.PhotoService;

@Controller
@RequestMapping("/api")
public class PhotoController {

    private final PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/api/music")
    public ResponseEntity<Page<Photo>> getMusic (Pageable pageable,
                                                 @RequestParam(defaultValue = "") String q) {
        return ResponseEntity.ok(photoService.getAll(pageable, q));
    }
}
