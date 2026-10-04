package com.nurassyl.sis1.model;

public class Task {
    private Long id;
    private String title;
    private String description;
    private String priority;
    private boolean completed;

    public Task (Long id, String title, String description, String priority, boolean completed){
        this.id=id;
        this.title=title;
        this.description=description;
        this.priority=priority;
        this.completed=completed;
    }

    public Long getId() {
        return id;
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

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }
}

