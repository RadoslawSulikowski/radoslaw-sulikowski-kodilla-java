package com.kodilla.rps;

class Computer{
    private int points;
    private String played;

    Computer(){
        points = 0;
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

    void addPoint(){
        points++;
    }

    void reset(){
        points = 0;
        played="";
    }
}
