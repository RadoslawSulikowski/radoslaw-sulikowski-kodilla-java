package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryDrivingTask(){
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task driving = factory.createTask(TaskFactory.DRIVING);
        //Then
        Assert.assertEquals("Driving", driving.getTaskName());
    }

    @Test
    public void testFactoryPaintingTask(){
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task painting = factory.createTask(TaskFactory.PAINTING);
        //Then
        Assert.assertEquals("Painting", painting.getTaskName());
    }

    @Test
    public void testFactoryShoppingTask(){
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shopping = factory.createTask(TaskFactory.SHOPPING);
        //Then
        Assert.assertEquals("Shopping", shopping.getTaskName());
    }

}
