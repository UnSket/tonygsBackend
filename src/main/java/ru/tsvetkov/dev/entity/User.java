package ru.tsvetkov.dev.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "users")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable{
    @Id
    @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "PATRONYMIC")
    private String patronymic;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "PHOTO_PATH")
    private String photo;

    @OneToOne
    @JoinColumn(name = "ROLE_ID")
    private Role role;


    public String getFullName() {
        return name + " " + surname;
    }
}