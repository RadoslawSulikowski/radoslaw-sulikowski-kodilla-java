package com.kodilla.patterns2.observer.homework;

public interface Observable {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver(Task task);
}
