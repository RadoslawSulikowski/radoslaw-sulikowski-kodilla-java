package com.kodilla.sudoku;

public class Backtrack {
    private SudokuBoard board;
    private int fieldNumber;
    private int chosenCandidate;

    public Backtrack(SudokuBoard board, int fieldNumber, int chosenCandidate) {
        this.board = board;
        this.fieldNumber = fieldNumber;
        this.chosenCandidate = chosenCandidate;
    }

    public SudokuBoard getBoard() {
        return board;
    }

    public int getFieldNumber() {
        return fieldNumber;
    }

    public int getChosenCandidate() {
        return chosenCandidate;
    }

    @Override
    public String toString() {
        return "Backtrack{" +
                "fieldNumber=" + fieldNumber +
                ", chosenCandidate=" + chosenCandidate +
                '}';
    }
}
