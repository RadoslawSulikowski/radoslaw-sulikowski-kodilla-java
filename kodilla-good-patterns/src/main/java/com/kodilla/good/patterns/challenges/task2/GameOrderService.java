package com.kodilla.good.patterns.challenges.task2;

public class GameOrderService implements OrderService {

    @Override
    public boolean order(User user, Product game, int orderedQuantity) {
        if (game.isAvailable(orderedQuantity)) {
            System.out.println("Service User: " + user.getName() + " " + user.getSurname() + " ordered " + orderedQuantity + " game(s).");
            game.reduceQuantity(orderedQuantity);
            System.out.println("" + game.getQuantity() + " game(s) left.");
            return true;
        }
        System.out.println("We have only " + game.getQuantity() + " game(s).");
        return false;
    }

}
