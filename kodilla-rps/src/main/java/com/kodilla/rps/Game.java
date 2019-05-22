package com.kodilla.rps;

import java.util.InputMismatchException;
import java.util.Scanner;

class Game{

    private Player player;
    private int pointsToWin;
    private Scanner scanner = new Scanner(System.in);
    private Computer computer = new Computer();

    Game(Player player, int pointsToWin){
        this.player = player;
        this.pointsToWin = pointsToWin;
    }

    void run(){
        boolean end = false;

        while(!end){
            System.out.print("Chose your action: ");

            switch(scanner.next()){

                case "1":
                    player.setPlayed("STONE");
                    Round.play(player, computer);
                    break;

                case "2":
                    player.setPlayed("PAPER");
                    Round.play(player, computer);
                    break;

                case "3":
                    player.setPlayed("SCISSORS");
                    Round.play(player, computer);
                    break;

                case "x":
                    boolean endCaseX = false;

                    while(!endCaseX){

                        System.out.println("Are you sure you want to end current game and exit? [y/n]");
                        switch(scanner.next()){

                            case "y":
                                end = true;
                                endCaseX = true;
                                break;

                            case "n":
                                endCaseX = true;
                                break;

                            default:
                                System.out.println("Pleas tap 'y' or 'n' and press [Enter].");
                                break;
                        }
                    }
                    break;

                case "n":
                    boolean endCaseN = false;

                    while(!endCaseN){
                        System.out.println("Are you sure you want to end current game and start new game? [y/n]");
                        switch(scanner.next()){

                            case "n":
                                endCaseN = true;
                                break;

                            case "y":
                                player.reset();
                                computer.reset();

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
                                endCaseN = true;
                                break;

                            default:
                                System.out.println("Pleas tap 'y' or 'n' and press [Enter].");
                                break;
                        }
                    }
                    break;

                default:
                    System.out.println("Unknown action. Pleas choose right action.");

            }

            Printer.printScores(player, computer);
            System.out.println();

            if(player.getPoints() == pointsToWin){
                System.out.println("You won the game!");
            }
            if(computer.getPoints() == pointsToWin){
                System.out.println("You lost the game!");
            }
            if(computer.getPoints() == pointsToWin || player.getPoints() == pointsToWin){
                System.out.println("What do you want to do?\n[x] - exit/[n] - new game");

                boolean finish = false;

                while(!finish){
                    switch(scanner.next()){

                        case "x":
                            end = true;
                            finish = true;
                            break;

                        case "n":
                            player.reset();
                            computer.reset();

                            System.out.print("How many points to win the game: ");

                            boolean pointsToWinInt = false;

                            while(!pointsToWinInt){
                                try{
                                    pointsToWin = scanner.nextInt();
                                    pointsToWinInt = true;
                                }catch(InputMismatchException e){
                                    System.out.println("Pleas enter integer");
                                    scanner.next();
                                }
                            }
                            finish = true;
                            break;

                        default:
                            System.out.println("Unknown action - chose [x] to exit or [n] for a new game.");
                            break;

                    }
                }
            }
        }
    }
}
