package com.kodilla.rps;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class Game{

    private Player player;
    private int pointsToWin;
    private Scanner scanner = new Scanner(System.in);
    private Computer computer = new Computer();
    private Random generator = new Random();

    Game(Player player){
        this.player = player;
        pointsToWin = 0;
    }

    void getPointsToWinFromPlayer(){
        System.out.print("How many points to win the game: ");

        boolean ifPointsToWinInt = false;

        while(!ifPointsToWinInt){
            try{
                pointsToWin = scanner.nextInt();
                ifPointsToWinInt = true;
            }catch(InputMismatchException e){
                System.out.println("Pleas enter integer");
                scanner.next();
            }
        }
    }

    private void runCaseStone(){

        int generated = generator.nextInt(5) + 1;

        if(generated == 1){//  COMPUTER PLAYS STONE
            System.out.println("YOU played STONE - Computer played STONE\nRound draw!");
        }
        if(generated == 2){//  COMPUTER PLAYS PAPER
            computer.addPoint();
            System.out.println("YOU played STONE - Computer played PAPER\nComputer won this round!");
        }
        if(generated == 3){//  COMPUTER PLAYS SCISSORS
            player.addPoint();
            System.out.println("YOU played STONE - Computer played SCISSORS\nYOU won this round!");
        }
        if(generated == 4){//  COMPUTER PLAYS REPTILE
            player.addPoint();
            System.out.println("YOU played STONE - Computer played REPTILE\nYOU won this round!");
        }
        if(generated == 5){//  COMPUTER PLAYS SPOCK
            computer.addPoint();
            System.out.println("YOU played STONE - Computer played SPOCK\nComputer won this round!");
        }
    }

    private void runCasePaper(){

        int generated = generator.nextInt(5) + 1;

        if(generated == 1){//  COMPUTER PLAYS STONE
            player.addPoint();
            System.out.println("YOU played PAPER - Computer played STONE\nYOU won this round!");
        }
        if(generated == 2){//  COMPUTER PLAYS PAPER
            System.out.println("YOU played PAPER - Computer played PAPER\n  Round draw!");
        }
        if(generated == 3){//  COMPUTER PLAYS SCISSORS
            computer.addPoint();
            System.out.println("YOU played PAPER - Computer played SCISSORS\nComputer won this round!");
        }
        if(generated == 4){//  COMPUTER PLAYS REPTILE
            computer.addPoint();
            System.out.println("YOU played PAPER - Computer played REPTILE\nComputer won this round!");
        }
        if(generated == 5){//  COMPUTER PLAYS SPOCK
            player.addPoint();
            System.out.println("YOU played PAPER - Computer played SPOCK\nYOU won this round!");
        }
    }

    private void runCaseScissors(){

        int generated = generator.nextInt(5) + 1;

        if(generated == 1){//  COMPUTER PLAYS STONE
            computer.addPoint();
            System.out.println("YOU played SCISSORS - Computer played STONE\nComputer won this round!");
        }
        if(generated == 2){//  COMPUTER PLAYS PAPER
            player.addPoint();
            System.out.println("YOU played SCISSORS - Computer played PAPER\nYOU won this round!");
        }
        if(generated == 3){//  COMPUTER PLAYS SCISSORS
            computer.addPoint();
            System.out.println("YOU played SCISSORS - Computer played SCISSORS\nRound draw!");
        }
        if(generated == 4){//  COMPUTER PLAYS REPTILE
            player.addPoint();
            System.out.println("YOU played SCISSORS - Computer played REPTILE\nYOU won this round!");
        }
        if(generated == 5){//  COMPUTER PLAYS SPOCK
            System.out.println("YOU played SCISSORS - Computer played SPOCK\nComputer won this round!");
        }
    }

    private void runCaseReptile(){

        int generated = generator.nextInt(5) + 1;

        if(generated == 1){//  COMPUTER PLAYS STONE
            computer.addPoint();
            System.out.println("YOU played REPTILE - Computer played STONE\nComputer won this round!");
        }
        if(generated == 2){//  COMPUTER PLAYS PAPER
            player.addPoint();
            System.out.println("YOU played REPTILE - Computer played PAPER\nYOU won this round!");
        }
        if(generated == 3){//  COMPUTER PLAYS SCISSORS
            computer.addPoint();
            System.out.println("YOU played REPTILE - Computer played SCISSORS\nComputer won this round!");
        }
        if(generated == 4){//  COMPUTER PLAYS REPTILE
            System.out.println("YOU played REPTILE - Computer played REPTILE\nRound draw!");
        }
        if(generated == 5){//  COMPUTER PLAYS SPOCK
            player.addPoint();
            System.out.println("YOU played REPTILE - Computer played SPOCK\nYOU won this round!");
        }
    }

    private void runCaseSpock(){

        int generated = generator.nextInt(5) + 1;

        if(generated == 1){//  COMPUTER PLAYS STONE
            player.addPoint();
            System.out.println("YOU played SPOCK - Computer played STONE\nYOU won this round!");
        }
        if(generated == 2){//  COMPUTER PLAYS PAPER
            computer.addPoint();
            System.out.println("YOU played SPOCK - Computer played PAPER\nComputer won this round!");
        }
        if(generated == 3){//  COMPUTER PLAYS SCISSORS
            player.addPoint();
            System.out.println("YOU played SPOCK - Computer played SCISSORS\nYOU won this round!");
        }
        if(generated == 4){//  COMPUTER PLAYS REPTILE
            computer.addPoint();
            System.out.println("YOU played SPOCK - Computer played REPTILE\nComputer won this round!");
        }
        if(generated == 5){//  COMPUTER PLAYS SPOCK
            System.out.println("YOU played SPOCK - Computer played SPOCK\nRound draw!");
        }
    }

    private boolean runCaseX(){

        System.out.println("Are you sure you want to end current game and exit? [y/n]");

        while(true){

            switch(scanner.next()){

                case "y":
                    return true;

                case "n":
                    return false;

                default:
                    System.out.println("Pleas tap 'y' or 'n' and press [Enter].");
                    break;
            }
        }
    }

    private void runCaseN(){

        boolean endCaseN = false;

        System.out.println("Are you sure you want to end current game and start new game? [y/n]");
        while(!endCaseN){
            switch(scanner.next()){

                case "n":
                    endCaseN = true;
                    break;

                case "y":
                    player.resetPoints();
                    computer.resetPoints();
                    getPointsToWinFromPlayer();
                    endCaseN = true;
                    break;

                default:
                    System.out.println("Pleas tap 'y' or 'n' and press [Enter].");
                    break;
            }
        }
    }

    private boolean runEndOfGame(){

        if(player.getPoints() == pointsToWin){
            System.out.println("YOU WON THE GAME!\n");
        }
        if(computer.getPoints() == pointsToWin){
            System.out.println("YOU LOST THE GAME!\n");
        }

        System.out.println("What do you want to do?\n[x] - exit/[n] - new game");

        while(true){
            switch(scanner.next()){

                case "x":
                    return true;

                case "n":
                    player.resetPoints();
                    computer.resetPoints();
                    getPointsToWinFromPlayer();
                    return false;

                default:
                    System.out.println("Unknown action - chose [x] to exit or [n] for a new game.");
                    break;
            }
        }
    }

    void run(){
        boolean end = false;

        while(!end){
            System.out.print("Chose your action (chose [i] - for instruction): ");

            switch(scanner.next()){

                case "1":   //PLAYER PLAYED STONE
                    runCaseStone();
                    break;

                case "2":   //PLAYER PLAYED PAPER
                    runCasePaper();
                    break;

                case "3":   //PLAYER PLAYED SCISSORS
                    runCaseScissors();
                    break;

                case "4":   //PLAYER PLAYED REPTILE
                    runCaseReptile();
                    break;

                case "5":   //PLAYER PLAYED SPOCK
                    runCaseSpock();
                    break;

                case "i":
                    Printer.printInstruction();
                    break;

                case "x":
                    end = runCaseX();
                    break;

                case "n":
                    runCaseN();
                    break;

                default:
                    System.out.println("Unknown action. Pleas choose right action.");
            }

            System.out.println(player.getName() + "    " + player.getPoints() + "-" + computer.getPoints() + "    COMPUTER");
            System.out.println();

            if(computer.getPoints() == pointsToWin || player.getPoints() == pointsToWin){
                end = runEndOfGame();
            }
        }
    }
}
