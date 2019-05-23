package com.kodilla.rps;

class Player{
    private String name;
    private int points;

    Player(String name){
        this.name = name;
        points = 0;
    }

    String getName(){
        return name;
    }

    int getPoints(){
        return points;
    }

   void resetPoints(){
        points = 0;
    }

    void addPoint(){
        points++;
    }
}
