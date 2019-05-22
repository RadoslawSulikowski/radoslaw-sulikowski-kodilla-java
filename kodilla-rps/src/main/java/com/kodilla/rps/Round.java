package com.kodilla.rps;

import java.util.Random;

public interface Round{

    Random generator = new Random();

    static void play(Player player, Computer computer){

        int generated = generator.nextInt(3)+1;
        String whoWonRound = "";

        if(generated == 1){
            computer.setPlayed("STONE");
            if(player.getPlayed().equals("PAPER")){
                player.addPoint();
                whoWonRound = player.getName();
            }
            if(player.getPlayed().equals("SCISSORS")){
                computer.addPoint();
                whoWonRound = "COMPUTER";
            }
        }else if(generated == 2){
            computer.setPlayed("PAPER");
            if(player.getPlayed().equals("SCISSORS")){
                player.addPoint();
                whoWonRound = player.getName();
            }
            if(player.getPlayed().equals("STONE")){
                computer.addPoint();
                whoWonRound = "COMPUTER";
            }
        }else{
            computer.setPlayed("SCISSORS");
            if(player.getPlayed().equals("STONE")){
                player.addPoint();
                whoWonRound = player.getName();
            }
            if(player.getPlayed().equals("PAPER")){
                computer.addPoint();
                whoWonRound = "COMPUTER";
            }
        }
        Printer.printPlayed(player, computer);
        if(!whoWonRound.equals("")){
            System.out.println(whoWonRound + " won this round!");
        }else{
            System.out.println("Round draw!");
        }



    }
}

