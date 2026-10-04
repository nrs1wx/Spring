package com.nurassyl.sis1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskUpdateRequest {
    @NotBlank
    @Size(max = 100)
    private String title;
    @Size(max = 500)
    private String description;
    @NotBlank
    private String priority;
    private boolean completed;

    public TaskUpdateRequest(){}

    public TaskUpdateRequest(String title, String description, String priority, boolean completed){
        this.title=title;
        this.description=description;
        this.priority=priority;
        this.completed=completed;
    }

    public String getTitle() {
        return title;
    }

    public String getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
