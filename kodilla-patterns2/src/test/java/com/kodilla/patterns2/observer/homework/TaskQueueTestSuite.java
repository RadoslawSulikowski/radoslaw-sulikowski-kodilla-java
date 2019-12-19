package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaskQueueTestSuite {
    @Test
    public void testInformMentor() {
        //Given
        Student student1 = new Student("student1Name");
        Student student2 = new Student("student2Name");
        Student student3 = new Student("student3Name");
        Student student4 = new Student("student4Name");
        Mentor mentor1 = new Mentor("mentor1Name");
        Mentor mentor2 = new Mentor("mentor2Name");
        mentor1.addStudent(student1);
        mentor1.addStudent(student3);
        mentor1.addStudent(student4);
        mentor2.addStudent(student1);
        mentor2.addStudent(student2);
        mentor2.addStudent(student4);
        //When
        student1.addTaskToQueue(new Task("student1 1-st task"));
        student1.addTaskToQueue(new Task("student1 2-nd task"));
        student2.addTaskToQueue(new Task("student2 1-st task"));
        student2.addTaskToQueue(new Task("student2 2-nd task"));
        student2.addTaskToQueue(new Task("student2 3-rd task"));
        student3.addTaskToQueue(new Task("student3 1-st task"));
        student4.addTaskToQueue(new Task("student4 1-st task"));
        student4.addTaskToQueue(new Task("student4 2-nd task"));

        String msgm1s3 = mentor1.getMessages().get(2);
        String msgm2s4_1 = mentor2.getMessages().get(5);
        //Then
        assertEquals(5, mentor1.getReceivedInformationCounter());
        assertEquals(7, mentor2.getReceivedInformationCounter());
        assertEquals("Student student3Name added new task: \"student3 1-st task\"", msgm1s3);
        assertEquals("Student student4Name added new task: \"student4 1-st task\"", msgm2s4_1);
    }
}
