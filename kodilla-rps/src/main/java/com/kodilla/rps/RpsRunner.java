package com.kodilla.rps;


import java.util.Scanner;

public class RpsRunner{

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter player name: ");
        String playerName = scanner.next();
        Player player = new Player(playerName);

        Game game = new Game(player);
        game.getPointsToWinFromPlayer();
        Printer.printInstruction();
        game.run();
    }
}
