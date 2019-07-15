package com.kodilla.patterns.prototype;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class BoardTestSuite {
    @Test
    public void testToString() {
        //Given
        TasksList toDoList = new TasksList("To Do Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> toDoList.getTasks().add(new Task("To Do Task number " + n)));

        TasksList inProgressList = new TasksList("In Progress List");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> inProgressList.getTasks().add(new Task("In Progress Task number " + n)));

        TasksList doneList = new TasksList("Done Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> doneList.getTasks().add(new Task("Done Task number " + n)));
        Board board = new Board("Project number 1");
        board.getLists().add(toDoList);
        board.getLists().add(inProgressList);
        board.getLists().add(doneList);

        Board clonedBoard = null;
        try {
            clonedBoard = board.shallowCopy();
            clonedBoard.setName("Project number 2");
        } catch(CloneNotSupportedException e) {
            System.out.println("Exception" + e);
        }

        Board deepClonedBoard = null;
        try {
            deepClonedBoard = board.deepCopy();
            deepClonedBoard.setName("Project number 3");
        } catch(CloneNotSupportedException e) {
            System.out.println("" + e);
        }

        //When
        board.getLists().remove(toDoList);
        for (TasksList list : board.getLists()) {
            if (list.getName().equals("Done Tasks")) {
                list.getTasks().remove(0);
            }
        }
        //Then
        System.out.println(board);
        System.out.println(clonedBoard);
        System.out.println(deepClonedBoard);
        Assert.assertEquals(2, board.getLists().size());
        Assert.assertEquals(2, clonedBoard.getLists().size());
        Assert.assertEquals(3, deepClonedBoard.getLists().size());
        Assert.assertEquals(clonedBoard.getLists(), board.getLists());
        Assert.assertNotEquals(deepClonedBoard.getLists(), board.getLists());
    }
}