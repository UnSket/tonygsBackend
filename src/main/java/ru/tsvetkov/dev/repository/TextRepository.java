package ru.tsvetkov.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tsvetkov.dev.entity.Text;

public interface TextRepository extends JpaRepository<Text, Long> {
}
