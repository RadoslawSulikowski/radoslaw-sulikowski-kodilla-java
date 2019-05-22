package com.kodilla.rps;

class Player{
    private String name;
    private int points;
    private String played;

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

    String getPlayed(){
        return played;
    }
    void setPlayed(String played){
        this.played = played;
    }

    void reset(){
        points = 0;
        played = "";
    }

    void addPoint(){
        points++;
    }
}
