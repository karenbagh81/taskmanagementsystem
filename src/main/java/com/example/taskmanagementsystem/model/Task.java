package com.example.taskmanagementsystem.model;

import com.example.taskmanagementsystem.enums.TaskStatus;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String taskName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date taskCreationDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date taskUpdateDate;

    private String taskStatus;


    @ManyToOne
    @JoinColumn(name = "user_fk")
    private User user;

    private String description;

}
