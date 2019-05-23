package com.kodilla.rps;

public interface Printer{

    static void printInstruction(){
        System.out.println("\nINSTRUCTION:\nDuring a game you can choose one of actions:\n\n" +
                "1 - play rock (defeats scissors and reptile)\n" +
                "2 - play paper (defeats rock and Spock)\n" +
                "3 - play scissors (defeats paper and reptile)\n" +
                "4 - play reptile (defeats paper and Spock)\n" +
                "5 - play Spock (defeats rock and scissors)\n" +
                "x - end game and exit\n" +
                "n - end current game and start new game\n" +
                "i - shows this instruction\n");
    }
}