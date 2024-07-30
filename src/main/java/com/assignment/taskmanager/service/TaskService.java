package com.assignment.taskmanager.service;

import com.assignment.taskmanager.model.Project;
import com.assignment.taskmanager.model.Task;
import com.assignment.taskmanager.repo.ProjectRepository;
import com.assignment.taskmanager.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public boolean addTask(Task task, String projectId) {
        return projectRepository.findById(projectId).map(project -> {
            task.setProject(project);
            taskRepository.save(task);
            return true;
        }).orElse(false);
    }

    public boolean updateTask(String taskId, Task task) {
        if (taskRepository.existsById(taskId)) {
            taskRepository.save(task);
            return true;
        }
        return false;
    }

    public boolean deleteTask(String taskId) {
        if (taskRepository.existsById(taskId)) {
            taskRepository.deleteById(taskId);
            return true;
        }
        return false;
    }

    public Task getTask(String taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }
}
