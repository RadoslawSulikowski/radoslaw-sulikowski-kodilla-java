package com.kodilla.patterns2.observer.homework;

public interface Observer {
    void inform(TaskQueue taskQueue, Task task);
}
