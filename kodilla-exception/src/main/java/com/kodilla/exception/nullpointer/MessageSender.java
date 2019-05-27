package com.kodilla.exception.nullpointer;

public class MessageSender{

    public void sendMesage(User user, String message) throws MessageNotSentException{
        if(user != null){
            System.out.println("Sending message: " + message + "to user " + user.getUsername());
        }else{
            throw new MessageNotSentException("Message not sent - Object User was null!");
        }

    }
}
