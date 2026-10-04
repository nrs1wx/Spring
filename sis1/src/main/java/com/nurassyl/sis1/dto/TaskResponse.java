package com.nurassyl.sis1.dto;

public class TaskResponse {
    private Long id;
    private String title;
    private String description;
    private String priority;
    private boolean completed;

    public TaskResponse (Long id, String title, String description, String priority, boolean completed){
        this.id=id;
        this.title=title;
        this.description=description;
        this.priority=priority;
        this.completed=completed;

    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
