package com.kodilla.spring.portfolio;

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
        //When
        board.getToDoList().addTask(toDoTask);
        board.getInProgressList().addTask(inProgressTask);
        board.getDoneList().addTask(doneTask);
        //Then
        System.out.println(board.getToDoList().getTask(0));
        System.out.println(board.getInProgressList().getTask(0));
        System.out.println(board.getDoneList().getTask(0));

    }
}
