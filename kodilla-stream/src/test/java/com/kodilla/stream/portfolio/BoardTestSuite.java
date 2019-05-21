package com.kodilla.stream.portfolio;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BoardTestSuite{
    public Board prepareTestData(){
        //users
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectManager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");
        //tasks
        Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking\n" +
                        "the temperature from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger",
                "Refactor company logger to meet our needs",
                user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));
        //taskLists
        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);
        //board
        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }

    @Test
    public void testAddTaskList(){
        //Given
        Board project = prepareTestData();

        //When
        int numberOfTaskLists = project.getTaskLists().size();

        //Then
        Assert.assertEquals(3, numberOfTaskLists);

    }

    @Test
    public void testAddTaskListFindUsersTasks(){
        //Given
        Board project = prepareTestData();

        //When
        User user = new User("developer1", "John Smith");
        List<Task> usersTasks = project.getTaskLists().stream()
                .flatMap(taskLists -> taskLists.getTasks().stream())
                .filter(task -> task.getAssignedUser().equals(user))
                .collect(toList());

        //Then
        Assert.assertEquals("Wrong number of tasks", 2, usersTasks.size());
        Assert.assertEquals("Wrong user of \"0\" task!", user, usersTasks.get(0).getAssignedUser());
        Assert.assertEquals("Wrong user of \"1\" task!",user, usersTasks.get(1).getAssignedUser());
    }

    @Test
    public void testAddTaskListFindOutdatedTasks(){
        //Given
        Board project = prepareTestData();

        //When
        List<Task> outdatedTasks = project.getTaskLists().stream()
                .filter(taskLists -> !taskLists.getName().equals("Done"))
                .flatMap(taskLists -> taskLists.getTasks().stream())
                .filter(task -> task.getDeadLine().isBefore(LocalDate.now()))
                .collect(toList());

        //Then
        Assert.assertEquals("Wrong number of tasks", 1, outdatedTasks.size());
        Assert.assertEquals("Wrong task returned", "HQLs for analysis", outdatedTasks.get(0).getTitle());
    }

    @Test
    public void testAddTaskListFindLongTasks(){
        //Given
        Board project = prepareTestData();

        //When
        List<Task> longTasks = project.getTaskLists().stream()
                .filter(taskLists -> taskLists.getName().equals("In progress"))
                .flatMap(taskLists -> taskLists.getTasks().stream())
                .filter(task -> task.getCreated().isBefore(LocalDate.now().minusDays(9)))
                .collect(toList());

        //Then
        Assert.assertEquals("Wrong number of tasks", 2, longTasks.size());
    }

    @Test
    public void testAddTaskListAverageWorkingOnTask(){
        //Given
        Board project = prepareTestData();

        //When
        double averageWorkingOnTask = project.getTaskLists().stream()
            .filter(taskLists -> taskLists.getName().equals("In progress"))
            .flatMap(taskLists -> taskLists.getTasks().stream())
            .mapToInt(task -> (int)LocalDate.now().toEpochDay() - (int)task.getCreated().toEpochDay())
            .average().getAsDouble();


        //Then
        /*In progress:
        task2: 20 days
        task4: 10 days
        task5: 0 days
        av. = 10 days
         */
        Assert.assertEquals(10, averageWorkingOnTask,0);

    }
}
