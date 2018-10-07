package ru.tsvetkov.dev.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "photo")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Photo {
    @Id
    @SequenceGenerator(
            name = "photo_sequence",
            sequenceName = "photo_sequence"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "photo_sequence")
    private Long id;

    private String description;

    @Column(name = "IMAGE_PATH")
    private String imagePath;
}
