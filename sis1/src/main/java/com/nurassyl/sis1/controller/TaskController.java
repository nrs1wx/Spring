package com.nurassyl.sis1.controller;


import com.nurassyl.sis1.dto.TaskCreateRequest;
import com.nurassyl.sis1.dto.TaskUpdateRequest;
import com.nurassyl.sis1.dto.TaskResponse;
import com.nurassyl.sis1.model.Task;
import com.nurassyl.sis1.service.TaskService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponse> create(
            @Valid @RequestBody TaskCreateRequest request) {

        Task task = new Task(
                null,
                request.getTitle(),
                request.getDescription(),
                request.getPriority(),
                false
        );

        Task createdTask = taskService.create(task);

        TaskResponse response = new TaskResponse(
                createdTask.getId(),
                createdTask.getTitle(),
                createdTask.getDescription(),
                createdTask.getPriority(),
                createdTask.isCompleted()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public List<TaskResponse> getAll() {

        return taskService.getAll()
                .stream()
                .map(task -> new TaskResponse(
                        task.getId(),
                        task.getTitle(),
                        task.getDescription(),
                        task.getPriority(),
                        task.isCompleted()
                ))
                .toList();
    }



    @GetMapping("/{id}")
    public TaskResponse getById(@PathVariable Long id) {

        Task task = taskService.getById(id);

        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getPriority(),
                task.isCompleted()
        );
    }

    @PutMapping("/{id}")
    public TaskResponse update(
            @PathVariable Long id,
            @Valid @RequestBody TaskUpdateRequest request) {

        Task updatedTask = new Task(
                id,
                request.getTitle(),
                request.getDescription(),
                request.getPriority(),
                request.isCompleted()
        );

        Task task = taskService.update(id, updatedTask);

        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getPriority(),
                task.isCompleted()
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }



}
