package com.kodilla.rps;

class Computer{
    private int points;

    Computer(){
        points = 0;
    }

    int getPoints(){
        return points;
    }

    void addPoint(){
        points++;
    }

    void resetPoints(){
        points = 0;
    }
}
