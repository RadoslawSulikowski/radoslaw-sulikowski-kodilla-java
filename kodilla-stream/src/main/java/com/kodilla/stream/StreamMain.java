package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args){

        Forum forum = new Forum();

        Map<Integer, ForumUser> resultMap = forum.getListOfUsers().stream()
                .filter(u -> u.getSex() == 'M')
                .filter(u -> (u.getDateOfBirth().isBefore(LocalDate.now().minusYears(20)))||
                        (u.getDateOfBirth().isEqual(LocalDate.now().minusYears(20))))
                .filter(u -> u.getPublishedPosts() > 0)
                .collect(Collectors.toMap(ForumUser::getUserIdentifier, u -> u));

        resultMap.forEach((key, value) -> System.out.println(value));

    }
}

