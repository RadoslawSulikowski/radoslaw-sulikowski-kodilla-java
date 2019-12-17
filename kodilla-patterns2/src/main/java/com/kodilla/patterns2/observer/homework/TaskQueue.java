package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class TaskQueue implements Observable {
    private final Student student;

    public TaskQueue(Student student) {
        this.student = student;
    }

    private List<Task> tasks = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
        notifyObserver(task);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(Task task) {
        for (Observer observer : observers) {
            observer.inform(this, task);
        }
    }

    public Student getStudent() {
        return student;
    }
}
