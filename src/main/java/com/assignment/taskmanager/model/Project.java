package com.assignment.taskmanager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Project {

    @Id
    private String projectId;
    private String type;
    private Date created;
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id") // This column will store the reference to the user
    private User user;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;
}
