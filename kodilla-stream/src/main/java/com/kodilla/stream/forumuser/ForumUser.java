package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser{
    private final int userIdentifier;
    private final String username;
    private final char sex;
    private final LocalDate dateOfBirth;
    private int publishedPosts;

    public ForumUser(int userIdentifier, String username, char sex, LocalDate dateOfBirt, int publicatedPosts){
        this.userIdentifier = userIdentifier;
        this.username = username;
        this.sex = sex;
        this.dateOfBirth = dateOfBirt;
        this.publishedPosts = publicatedPosts;
    }

    public int getUserIdentifier(){

        return userIdentifier;
    }

    public String getUsername(){

        return username;
    }

    public char getSex(){

        return sex;
    }

    public LocalDate getDateOfBirth(){

        return dateOfBirth;
    }

    public int getPublishedPosts(){

        return publishedPosts;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }

        ForumUser forumUser = (ForumUser) o;

        if(userIdentifier != forumUser.userIdentifier){
            return false;
        }
        if(sex != forumUser.sex){
            return false;
        }
        if(publishedPosts != forumUser.publishedPosts){
            return false;
        }
        if(!username.equals(forumUser.username)){
            return false;
        }
        return dateOfBirth.equals(forumUser.dateOfBirth);

    }

    @Override
    public int hashCode(){
        int result = userIdentifier;
        result = 31 * result + username.hashCode();
        result = 31 * result + (int) sex;
        result = 31 * result + dateOfBirth.hashCode();
        result = 31 * result + publishedPosts;
        return result;
    }

    @Override
    public String toString(){
        return "ForumUser{" +
                "userIdentifier=" + userIdentifier +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", publishedPosts=" + publishedPosts +
                '}';
    }
}
