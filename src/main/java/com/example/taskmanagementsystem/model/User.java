package com.example.taskmanagementsystem.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    @NotNull
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Task> task;

    @ManyToOne
    private Role role;

}
