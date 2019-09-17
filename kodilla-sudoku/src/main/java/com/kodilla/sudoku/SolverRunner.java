package com.kodilla.sudoku;

public class SolverRunner {
    public static void main (String[] args){

        SudokuBoard board = new SudokuBoard();
        board.createBoard();
        System.out.println(board.toString());

    }
}
