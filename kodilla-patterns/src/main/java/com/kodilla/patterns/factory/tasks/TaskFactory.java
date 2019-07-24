package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";

    public Task createTask(String taskName) {
        switch (taskName) {
            case DRIVING:
                return new DrivingTask("Driving", "Moon", "Broom");
            case PAINTING:
                return new PaintingTask("Painting", "pale-dill-pink", "Toilet seat");
            case SHOPPING:
                return new ShoppingTask("Shopping", "pale-dill-pink paint", 4.25);
            default:
                return null;
        }
    }

}
