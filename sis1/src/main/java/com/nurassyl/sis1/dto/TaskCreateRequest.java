package com.nurassyl.sis1.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskCreateRequest {
    @NotBlank
    @Size(max=100)
    private String title;

    @Size(max=500)
    private String description;

    @NotBlank
    private String priority;

    public TaskCreateRequest(){}
    public TaskCreateRequest(String title, String description, String priority){
        this.title=title;
        this.description=description;
        this.priority=priority;
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
