package com.assignment.taskmanager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Task {

    @Id
    private String taskId;
    private String status;
    private String name;
    private Date created;

    @ManyToOne
    @JoinColumn(name = "project_id") // This column will store the reference to the project
    private Project project;
}
