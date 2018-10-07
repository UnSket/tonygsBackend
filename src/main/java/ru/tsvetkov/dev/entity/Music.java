package ru.tsvetkov.dev.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "music")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Music {
    @Id
    @SequenceGenerator(
            name = "music_sequence",
            sequenceName = "music_sequence"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "music_sequence")
    private Long id;

    private String description;

    @Column(name = "IMAGE_PATH")
    private String imagePath;

    private String link;

    private String name;
}
