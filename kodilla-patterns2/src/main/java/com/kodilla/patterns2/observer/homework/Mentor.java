package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Mentor implements Observer {

    private final String name;
    private List<Student> students = new ArrayList<>();
    private List<String> messages = new ArrayList<>();
    private int receivedInformationCounter;

    public Mentor(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.getTaskQueue().registerObserver(this);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        student.getTaskQueue().removeObserver(this);
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getReceivedInformationCounter() {
        return receivedInformationCounter;
    }

    public List<String> getMessages() {
        return messages;
    }

    @Override
    public void inform(TaskQueue taskQueue, Task task) {
        System.out.println("Student " + taskQueue.getStudent().getName() + " added new task: \"" + task.getName() + "\"");
        messages.add("Student " + taskQueue.getStudent().getName() + " added new task: \"" + task.getName() + "\"");
        receivedInformationCounter++;
    }
}
