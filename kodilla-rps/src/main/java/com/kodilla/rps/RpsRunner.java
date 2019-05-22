package com.kodilla.rps;


import java.util.InputMismatchException;
import java.util.Scanner;

public class RpsRunner{
    private static int pointsToWin;

    public static void main(String[] args){
        boolean ifPointsToWinInt;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter player name: ");
        String playerName = scanner.next();
        Player player = new Player(playerName);

        System.out.print("How many points to win the game: ");
        ifPointsToWinInt = false;
        while(!ifPointsToWinInt){
            try{
                pointsToWin = scanner.nextInt();
                ifPointsToWinInt = true;
            }catch(InputMismatchException e){
                System.out.println("Pleas enter integer");
                scanner.next();
            }
        }
        System.out.println("During a game you can choose one of actions: \n1 - play rock\n2 - play paper\n3 - " +
                "play scissors\nx - end game and exit\nn - end current game and start new game\n");
        Game game = new Game(player, pointsToWin);
        game.run();
    }
}
