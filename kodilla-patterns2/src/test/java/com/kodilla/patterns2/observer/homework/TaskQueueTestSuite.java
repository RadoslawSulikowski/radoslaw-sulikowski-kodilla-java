package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaskQueueTestSuite {
    @Test
    public void testInformMentor() {
        //Given
        Student student = new Student("studentName");
        Mentor mentor = new Mentor("mentorName");
        mentor.addStudent(student);
        //When
        student.addTaskToQueue(new Task("First task"));
        student.addTaskToQueue(new Task("Second task"));
        String message1 = mentor.getMessages().get(0);
        String message2 = mentor.getMessages().get(1);
        //Then
        assertEquals(2, mentor.getReceivedInformationCounter());
        assertEquals("Student studentName added new task: \"First task\"", message1);
        assertEquals("Student studentName added new task: \"Second task\"", message2);
    }
}
