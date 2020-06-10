package com.example.TimeManagement.TasksAPI.controller;

import com.example.TimeManagement.TasksAPI.model.Task;
import com.example.TimeManagement.TasksAPI.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    // Get All tasks
    @GetMapping("/tasks")
    public List<Task> getAllNotes() {
        return taskRepository.findAll();
    }

    // Create a new task
    @PostMapping("/tasks")
    public Task createTask(@Valid @RequestBody Task task) {
        return taskRepository.save(task);
    }

    // Get a Single task
    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable(value = "id") Long taskId) throws TaskNotFoundException {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));
    }

    // Update a Task
    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable(value = "id") Long taskId,
                           @Valid @RequestBody Task taskDetails) throws TaskNotFoundException {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));

        task.setContent(taskDetails.getContent());
        task.setCompleted(taskDetails.getCompleted());


        Task updatedTask = taskRepository.save(task);

        return updatedTask;
    }

    // Delete a task
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable(value = "id") Long taskId) throws TaskNotFoundException {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));

        taskRepository.delete(task);

        return ResponseEntity.ok().build();
    }
}
