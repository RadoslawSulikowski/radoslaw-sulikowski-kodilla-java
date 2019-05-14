package com.kodilla.testing.forum.statistics;

import java.util.List;

public interface Statistics {
    List<String> userNames();   //returns list of user names
    int postCount();            //returns total quantity of user posts
    int commentCount();         //returns total quantity of user comments
}
