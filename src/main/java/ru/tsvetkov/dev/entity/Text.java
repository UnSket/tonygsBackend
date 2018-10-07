package ru.tsvetkov.dev.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "texts")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Text {
    @Id
    private Long id;

    private String text;

}
