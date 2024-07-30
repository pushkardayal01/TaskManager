package com.assignment.taskmanager.service;

import com.assignment.taskmanager.model.Project;
import com.assignment.taskmanager.model.User;
import com.assignment.taskmanager.repo.ProjectRepository;
import com.assignment.taskmanager.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Project> getProjects(String userId) {
        return userRepository.findById(userId).map(User::getProjects).orElse(null);
    }

    public Project getProject(String userId, String projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    public boolean updateProject(String projectId, Project project) {
        if (projectRepository.existsById(projectId)) {
            projectRepository.save(project);
            return true;
        }
        return false;
    }

    public boolean deleteProject(String userId, String projectId) {
        if (projectRepository.existsById(projectId)) {
            projectRepository.deleteById(projectId);
            return true;
        }
        return false;
    }

    public boolean addProject(Project project, String userId) {
        return userRepository.findById(userId).map(user -> {
            project.setUser(user);
            projectRepository.save(project);
            return true;
        }).orElse(false);
    }
}
