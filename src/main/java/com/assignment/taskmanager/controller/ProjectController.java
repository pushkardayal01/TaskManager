package com.assignment.taskmanager.controller;

import com.assignment.taskmanager.model.Project;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProjectController {

    @GetMapping("/")
    public String greet() {
        return "Hello!";
    }

    @GetMapping("/project")
    public ResponseEntity<String> getProjects() {
        return new ResponseEntity<>("Project list", HttpStatus.OK);
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<String> getProject(@PathVariable String ProjectId) {
        return new ResponseEntity<>("Project with ID: " + ProjectId, HttpStatus.OK);
    }

    @PostMapping("/project")
    public ResponseEntity<String> addProject(@RequestBody Project project) {
        return new ResponseEntity<>("Project is added", HttpStatus.OK);
    }

    @PutMapping("/Project")
    public ResponseEntity<String> updateProject(@RequestBody Project project) {
        return new ResponseEntity<>("Project is updated", HttpStatus.OK);
    }

    @DeleteMapping("/Project/{ProjectId}")
    public ResponseEntity<String> deleteProject(@PathVariable String ProjectId) {
        return new ResponseEntity<>("Project is deleted", HttpStatus.OK);
    }
}
