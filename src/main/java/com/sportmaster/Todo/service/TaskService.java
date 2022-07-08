package com.sportmaster.Todo.service;

import com.sportmaster.Todo.document.Task;
import com.sportmaster.Todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository repository;

    @Autowired
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public void save(final Task task) {
        repository.save(task);
    }

    public Task findById(final String id) {
        return repository.findById(id).orElse(null);
    }

    public List<Task> findAll() {
        List<Task> allTasks = Collections.emptyList();
        repository.findAll().forEach(allTasks::add);
        return allTasks;
    }

    public boolean deleteTask(final String id) {
        try {
            this.repository.deleteById(id);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
