package com.assignment.taskmanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    @GetMapping("/")
    public String build(){
        return "hello task";
    }

    @GetMapping("/tasks")
    public ResponseEntity<?> getTasks(){
        return new ResponseEntity<>("tasks", HttpStatus.OK);
    }

    @GetMapping("/tasks/{taskid}")
    public ResponseEntity<?> getTask(@PathVariable String taskid){
        return new ResponseEntity<>("task one",HttpStatus.OK);
    }

    @PostMapping("/task")
    public ResponseEntity<?> addTask(){
        return new ResponseEntity<>("task is added",HttpStatus.OK);
    }

    @PutMapping("/task")
    public ResponseEntity<?> updateTask(){
        return new ResponseEntity<>("Task is updated",HttpStatus.OK);
    }

    @PutMapping("task/taskid/status")
    public ResponseEntity<?> updateStatus(){
        return new ResponseEntity<>("Status is updated",HttpStatus.OK);
    }

    @DeleteMapping("task/{taskid}")
    public ResponseEntity<?> deletetask(@PathVariable String taskid){
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }
}
