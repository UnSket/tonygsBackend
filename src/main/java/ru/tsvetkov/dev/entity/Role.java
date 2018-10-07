package ru.tsvetkov.dev.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity(name = "ROLE")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Immutable
public class Role {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;
}
