package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        String toDoTask = "to do task";
        String inProgressTask = "in progress task";
        String doneTask = "done task";
        board.getToDoList().addTask(toDoTask);
        board.getInProgressList().addTask(inProgressTask);
        board.getDoneList().addTask(doneTask);
        //When
        String resultToDoTask = board.getToDoList().getTask(0);
        String resultInProgressTask = board.getInProgressList().getTask(0);
        String resultDoneTask = board.getDoneList().getTask(0);
        //Then
        Assert.assertEquals("to do task", resultToDoTask);
        Assert.assertEquals("in progress task", resultInProgressTask);
        Assert.assertEquals("done task", resultDoneTask);
    }
}
