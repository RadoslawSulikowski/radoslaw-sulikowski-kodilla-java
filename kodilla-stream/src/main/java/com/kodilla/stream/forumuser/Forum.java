package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum{
    private final List<ForumUser> listOfUsers = new ArrayList<>();

   public Forum(){
       listOfUsers.add(new ForumUser(1, "user1", 'M', LocalDate.of(1991,1,1), 1));
       listOfUsers.add(new ForumUser(2, "user2", 'F', LocalDate.of(1992,2,2), 2));
       listOfUsers.add(new ForumUser(3, "user3", 'M', LocalDate.of(1993,3,3), 3));
       listOfUsers.add(new ForumUser(4, "user4", 'F', LocalDate.of(1994,4,4), 4));
       listOfUsers.add(new ForumUser(5, "user5", 'M', LocalDate.of(1995,5,5), 0));
       listOfUsers.add(new ForumUser(6, "user6", 'F', LocalDate.of(1996,6,6), 6));
       listOfUsers.add(new ForumUser(7, "user7", 'M', LocalDate.of(1997,7,7), 7));
       listOfUsers.add(new ForumUser(8, "user8", 'F', LocalDate.of(1998,8,8), 0));
       listOfUsers.add(new ForumUser(9, "user9", 'M', LocalDate.of(1999,5,19), 9));
       listOfUsers.add(new ForumUser(10, "user10", 'F', LocalDate.of(2000,10,10), 10));
       listOfUsers.add(new ForumUser(11, "user11", 'M', LocalDate.of(2001,05,19), 11));
       listOfUsers.add(new ForumUser(12, "user12", 'F', LocalDate.of(2002,12,12), 12));

   }


    public List<ForumUser> getListOfUsers(){

        return listOfUsers;
    }
}
