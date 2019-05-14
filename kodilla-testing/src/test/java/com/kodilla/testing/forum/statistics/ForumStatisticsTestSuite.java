package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {

    private static int testCounter;

    @BeforeClass
    public static void beforeAllTests(){
        System.out.println("Beginning of tests");
    }
    @AfterClass
    public static void afterAllTests(){
        System.out.println("All tests are finished");
    }
    @Before
    public void beforeEveryTest(){
        testCounter++;
        System.out.print("Beginning test #" + testCounter + "......  ");
    }
    @After
    public void afterEveryTest(){
        System.out.println("Test completed");
    }

    @Test
    public void testCalculateNumberOfUsers(){
        //Given
        StatisticsCalculator statisticCalculator = new StatisticsCalculator();
        Statistics statistics = mock(Statistics.class);

        List<String> usersList = new ArrayList<>();
        for(int i = 0; i < 100; i++){usersList.add("User Name");}
        when(statistics.userNames()).thenReturn(usersList);

        statisticCalculator.calculateAdvStatistics(statistics);

        //When
        int retrievedNumberOfUsers = statisticCalculator.getNumberOfUsers();

        //Then
        Assert.assertEquals(100, retrievedNumberOfUsers);
    }

    @Test
    public void testCalculateNumberOfPosts(){
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        Statistics statistics = mock(Statistics.class);

        when(statistics.postCount()).thenReturn(1000);
        statisticsCalculator.calculateAdvStatistics(statistics);

        //When
        int retrievedNumberOfPosts = statisticsCalculator.getTotalNumberOfPosts();

        //Then
        Assert.assertEquals(1000, retrievedNumberOfPosts);
    }

    @Test
    public void testCalculateNumberOfComments(){
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        Statistics statistics = mock(Statistics.class);

        when(statistics.commentCount()).thenReturn(0);
        statisticsCalculator.calculateAdvStatistics(statistics);

        //When
        int retrievedNumberOfComments = statisticsCalculator.getTotalNumberOfComments();

        //Then
        Assert.assertEquals(0, retrievedNumberOfComments);
    }

    @Test
    public void testCalculatePostsPerUserWithNoUsers(){
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        Statistics statistics = mock(Statistics.class);

        List<String> usersList = new ArrayList<>();
        when(statistics.userNames()).thenReturn(usersList);
        when(statistics.postCount()).thenReturn(1000);

        statisticsCalculator.calculateAdvStatistics(statistics);

        //When
        double retrievedPostPerUser = statisticsCalculator.getPostsPerUser();

        //Then
        Assert.assertEquals(0, retrievedPostPerUser, 1.0E-09);
    }

    @Test
    public void testCalculatePostsPerUser(){
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        Statistics statistics = mock(Statistics.class);

        List<String> usersList = new ArrayList<>();
        for(int i = 0; i < 100; i++){usersList.add("User Name");}
        when(statistics.userNames()).thenReturn(usersList);
        when(statistics.postCount()).thenReturn(1000);

        statisticsCalculator.calculateAdvStatistics(statistics);

        //When
        double retrievedPostPerUser = statisticsCalculator.getPostsPerUser();

        //Then
        Assert.assertEquals(10, retrievedPostPerUser, 1.0E-09);
    }

    @Test
    public void testCalculateCommentsPerUserWithNoUsers(){
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        Statistics statistics = mock(Statistics.class);

        List<String> usersList = new ArrayList<>();
        when(statistics.userNames()).thenReturn(usersList);
        when(statistics.commentCount()).thenReturn(456);

        statisticsCalculator.calculateAdvStatistics(statistics);

        //When
        double retrievedCommentsPerUser = statisticsCalculator.getCommentsPerUser();

        //Then
        Assert.assertEquals(0, retrievedCommentsPerUser, 1.0E-09);
    }

    @Test
    public void testCalculateCommentsPerUser(){
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        Statistics statistics = mock(Statistics.class);

        List<String> usersList = new ArrayList<>();
        for(int i = 0; i < 100; i++){usersList.add("User Name");}
        when(statistics.userNames()).thenReturn(usersList);
        when(statistics.commentCount()).thenReturn(456);

        statisticsCalculator.calculateAdvStatistics(statistics);

        //When
        double retrievedCommentsPerUser = statisticsCalculator.getCommentsPerUser();

        //Then
        Assert.assertEquals(4.56, retrievedCommentsPerUser, 1.0E-09);
    }

    @Test
    public void commentsPerPostWithNoPosts(){
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        Statistics statistics = mock(Statistics.class);

        when(statistics.postCount()).thenReturn(0);
        when(statistics.commentCount()).thenReturn(456);

        statisticsCalculator.calculateAdvStatistics(statistics);

        //When
        double retrievedCommentsPerPost = statisticsCalculator.getCommentsPerPost();

        //Then
        Assert.assertEquals(0, retrievedCommentsPerPost, 1.0E-09);
    }

    @Test
    public void commentsPerPostMoreCommentsThanPosts(){
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        Statistics statistics = mock(Statistics.class);

        when(statistics.postCount()).thenReturn(156);
        when(statistics.commentCount()).thenReturn(987);

        statisticsCalculator.calculateAdvStatistics(statistics);

        //When
        double retrievedCommentsPerPost = statisticsCalculator.getCommentsPerPost();

        //Then
        Assert.assertEquals(987.0/156.0, retrievedCommentsPerPost, 1.0E-09);
    }

    @Test
    public void commentsPerPostMorePostsThanComments(){
        //Given
        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        Statistics statistics = mock(Statistics.class);

        when(statistics.postCount()).thenReturn(654321);
        when(statistics.commentCount()).thenReturn(123456);

        statisticsCalculator.calculateAdvStatistics(statistics);

        //When
        double retrievedCommentsPerPost = statisticsCalculator.getCommentsPerPost();

        //Then
        Assert.assertEquals(123456.0/654321.0, retrievedCommentsPerPost, 1.0E-09);
    }

}
