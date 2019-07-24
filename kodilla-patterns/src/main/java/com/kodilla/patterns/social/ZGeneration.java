package com.kodilla.patterns.social;

public class ZGeneration extends User {
    public ZGeneration(String userName) {
        super(userName);
        this.socialPublisher = new SnapChatPublisher();
    }
}
