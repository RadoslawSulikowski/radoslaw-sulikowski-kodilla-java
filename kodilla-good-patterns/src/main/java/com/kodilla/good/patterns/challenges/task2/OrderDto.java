package com.kodilla.good.patterns.challenges.task2;

public class OrderDto {

    private User user;
    private boolean isOrdered;

    public OrderDto(User user, boolean orderAccepted) {
        this.user = user;
        this.isOrdered = orderAccepted;
    }

    public User getUser() {
        return user;
    }

    public boolean isOrderAccepted() {
        return isOrdered;
    }

}

