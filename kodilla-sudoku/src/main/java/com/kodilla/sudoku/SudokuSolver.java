package com.kodilla.sudoku;

import java.util.Scanner;

class SudokuSolver {
    private SudokuBoard inputBoard = new SudokuBoard();
    private Scanner scanner = new Scanner(System.in);

    SudokuSolver() {
        inputBoard.createBoard();
    }

    private void getDataFromUser() {
        int row, column, value, fieldNumber;
        String line;
        String[] lineVector;
        boolean resolve = false;
        while (!resolve) {
            line = scanner.nextLine();
            if (line.equals("SUDOKU")) {
                resolve = true;
            } else {
                lineVector = line.split(",");
                for (int i = 0; i < (lineVector.length - 1) / 3 + 1; i++) {
                    column = Integer.parseInt(lineVector[3 * i ]);
                    row = Integer.parseInt(lineVector[3 * i + 1]);
                    value = Integer.parseInt(lineVector[3 * i + 2]);
                    fieldNumber = 9 * (row - 1) + column - 1;

                    SudokuField field = inputBoard.getFieldByFieldNumber(fieldNumber);
                    field.setValue(value);
                    if (inputBoard.hasNoDuplicateValuesInRowColumnOrSection()) {
                        field.setColumn(column);
                        field.setRow(row);
                        field.setSection((((row - 1) / 3) * 3 + (column - 1) / 3) + 1);
                        field.setUserValue(true);
                    } else {
                        field.setValue(SudokuField.EMPTY);
                        System.out.println("Value " + value + " is not allowed in column " + column + " and row " + row);
                    }

                    System.out.println(inputBoard.toString());
                }
            }
        }
    }

    boolean resolveSudoku() {
        getDataFromUser();

        SudokuBoard board = inputBoard.copyBoard();
        board.prepareBoard();
        if (board.solve()) {
            System.out.println("Your sudoku has been solved correctly." + board.toString());
            return true;
        } else {
            System.out.println("Your sudoku has no solution. Pleas check your input board:\n" + inputBoard.toString());
            return false;
        }
    }
}