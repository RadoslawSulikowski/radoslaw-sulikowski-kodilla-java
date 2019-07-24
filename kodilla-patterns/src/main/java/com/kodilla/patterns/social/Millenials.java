package com.kodilla.patterns.social;

public class Millenials extends User {
    public Millenials(String userName) {
        super(userName);
        this.socialPublisher = new FacebookPublisher();
    }
}
