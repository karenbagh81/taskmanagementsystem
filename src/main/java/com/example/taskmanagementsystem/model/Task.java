package com.example.taskmanagementsystem.model;

import com.example.taskmanagementsystem.enums.TaskStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String taskName;

    private Date taskCreationDate;

    private Date taskUpdateDate;

    private TaskStatus taskStatus;


    @ManyToOne
    @JoinColumn(name = "user_fk")
    private User user;

    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getTaskCreationDate() {
        return taskCreationDate;
    }

    public void setTaskCreationDate(Date taskCreationDate) {
        this.taskCreationDate = taskCreationDate;
    }

    public Date getTaskUpdateDate() {
        return taskUpdateDate;
    }

    public void setTaskUpdateDate(Date taskUpdateDate) {
        this.taskUpdateDate = taskUpdateDate;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                Objects.equals(taskName, task.taskName) &&
                Objects.equals(taskCreationDate, task.taskCreationDate) &&
                Objects.equals(taskUpdateDate, task.taskUpdateDate) &&
                taskStatus == task.taskStatus &&
                Objects.equals(user, task.user) &&
                Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskName, taskCreationDate, taskUpdateDate, taskStatus, user, description);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskCreationDate=" + taskCreationDate +
                ", taskUpdateDate=" + taskUpdateDate +
                ", taskStatus=" + taskStatus +
                ", user=" + user +
                ", description='" + description + '\'' +
                '}';
    }
}
