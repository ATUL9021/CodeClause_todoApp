package com.example.todo;

public class Model {
    String description, task;

    public String getDescription() {
        return description;
    }

    public Model(String task, String description) {
        this.description = description;
        this.task = task;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
