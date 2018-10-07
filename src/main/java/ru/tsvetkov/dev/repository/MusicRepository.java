package ru.tsvetkov.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.tsvetkov.dev.entity.Music;

public interface MusicRepository extends JpaRepository<Music, Long>, JpaSpecificationExecutor<Music> {
}
