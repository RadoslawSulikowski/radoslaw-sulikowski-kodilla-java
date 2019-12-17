package com.kodilla.patterns2.observer.homework;

public class Student {

    private final String name;
    private TaskQueue taskQueue = new TaskQueue(this);

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public TaskQueue getTaskQueue() {
        return taskQueue;
    }

    public void addTaskToQueue(Task task) {
        taskQueue.addTask(task);
    }
}
