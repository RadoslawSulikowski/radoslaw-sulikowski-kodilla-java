package com.kodilla.exception.nullpointer;

public class NullPointerExceptionRunner{
    public static void main(String[] args){

        User user = null;
        MessageSender messageSender = new MessageSender();

        try{
            messageSender.sendMesage(user, "Message");
        }catch(MessageNotSentException e){
            System.out.println(e.getMessage());
        }
    }
}
