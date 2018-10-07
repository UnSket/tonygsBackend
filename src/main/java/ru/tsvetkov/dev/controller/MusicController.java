package ru.tsvetkov.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tsvetkov.dev.entity.Music;
import ru.tsvetkov.dev.service.MusicService;

@Controller
@RequestMapping("/api")
public class MusicController {
    private final MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping("/api/music")
    public ResponseEntity<Page<Music>> getMusic (Pageable pageable,
                                                 @RequestParam(defaultValue = "") String q) {
        return ResponseEntity.ok(musicService.getAll(pageable, q));
    }
}
