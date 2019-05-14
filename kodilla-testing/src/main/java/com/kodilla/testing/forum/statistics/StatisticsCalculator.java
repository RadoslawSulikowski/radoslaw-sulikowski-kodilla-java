package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {
    private int numberOfUsers;
    private int totalNumberOfPosts;
    private int totalNumberOfComments;
    private double postsPerUser;
    private double commentsPerUser;
    private double commentsPerPost;

    public void calculateAdvStatistics(Statistics statistics){
        this.numberOfUsers = statistics.userNames().size();
        this.totalNumberOfPosts = statistics.postCount();
        this.totalNumberOfComments = statistics.commentCount();
        if(this.numberOfUsers == 0){
            this.postsPerUser = 0;
            this.commentsPerUser = 0;
        } else {
            this.postsPerUser = (double) this.totalNumberOfPosts / (double) this.numberOfUsers;
            this.commentsPerUser = (double) this.totalNumberOfComments / (double) this.numberOfUsers;
        }
        if(this.totalNumberOfPosts == 0){
            this.commentsPerPost = 0;
        } else {
            this.commentsPerPost = (double) this.totalNumberOfComments / (double) this.totalNumberOfPosts;
        }
    }

    public void showStatistics(){
        System.out.println("numberOfUsers: " + this.numberOfUsers);
        System.out.println("totalNumberOfPosts: " + this.totalNumberOfPosts);
        System.out.println("totalNumberOfComments: " + this.totalNumberOfComments);
        System.out.println("postsPerUser: " + this.postsPerUser);
        System.out.println("commentsPerUser: " + this.commentsPerUser);
        System.out.println("commentsPerPost: " + this.commentsPerPost);
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public int getTotalNumberOfPosts() {
        return totalNumberOfPosts;
    }

    public int getTotalNumberOfComments() {
        return totalNumberOfComments;
    }

    public double getPostsPerUser() {
        return postsPerUser;
    }

    public double getCommentsPerUser() {
        return commentsPerUser;
    }

    public double getCommentsPerPost() {
        return commentsPerPost;
    }
}
