package com.kodilla.stream.forum;

import java.util.HashSet;
import java.util.Set;

public final class ForumUser{
    private final String username;
    private final String realName;
    private final String location;
    private final Set<ForumUser> friends = new HashSet<>();

    public ForumUser(final String username, final String realName, final String location){
        this.username = username;
        this.realName = realName;
        this.location = location;
    }
}
