package com.kodilla.sudoku;

import static com.kodilla.sudoku.SudokuField.EMPTY;

public class SudokuBoard {

    private SudokuField[] board = new SudokuField[81];

    public void createBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = new SudokuField();
            board[i].setValue(EMPTY);
            board[i].setRow(i / 9 + 1);
            board[i].setFieldNumber(i);
            board[i].setColumn(i % 9 + 1);
            board[i].setSection((((board[i].getRow() - 1) / 3) * 3 + (board[i].getColumn() - 1) / 3) + 1);
        }
    }




    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            if (i % 27 == 0) {
                result.append("\n\t-----------------------");
            }
            if (i % 9 == 0) {
                result.append("\n");
            }
            if (i % 3 == 0) {
                result.append("\t|");
            }
            result.append(board[i].getValue()).append("|");
        }
        result.append("\n\t-----------------------");
        return result.toString();
    }
}
