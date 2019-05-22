package com.kodilla.rps;

public interface Printer{
    static void printScores(Player player, Computer computer){
        System.out.println(player.getName() + "\t" + player.getPoints() + "-" + computer.getPoints() + "\tCOMPUTER");
    }

    static void printPlayed(Player player, Computer computer){
        if(!player.getPlayed().equals("")&&!computer.getPlayed().equals("")){
            System.out.println(player.getName() + " played: " + player.getPlayed() + "\nComputer played: " + computer.getPlayed());
        }
    }
}
