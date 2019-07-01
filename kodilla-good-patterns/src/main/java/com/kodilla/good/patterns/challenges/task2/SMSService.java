package com.kodilla.good.patterns.challenges.task2;

public class SMSService implements InformationService {

    @Override
    public void inform(User user) {
        System.out.println("SMS with order confirmation was sent to " + user.getName() + " " + user.getSurname() + ".");
    }

}
