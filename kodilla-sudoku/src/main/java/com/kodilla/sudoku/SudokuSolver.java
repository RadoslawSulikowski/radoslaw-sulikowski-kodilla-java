package com.kodilla.sudoku;

import java.util.ArrayDeque;
import java.util.Deque;
//import java.util.Scanner;

class SudokuSolver {
    private SudokuBoard board;
    private Deque<Backtrack> backtracks = new ArrayDeque<>();
    //private Scanner scanner = new Scanner(System.in);

    SudokuSolver(SudokuBoard board) {
        this.board = board;
    }

    SudokuBoard getBoard() {
        return board;
    }

    void solve() {
        boolean solved = false;
        boolean solvedCorrect;
        while (!solved) {
            boolean end = false;
            while (!end) {
                end = board.singlePosition() && board.singleCandidate();
            }
            if (!(board.isFilled())) {
                if (!board.hasFieldWithNoCandidates()) {
                    int fieldNumber = board.firstFieldWithTheLeastCandidates();
                    int chosenCandidate = board.getFieldByFieldNumber(fieldNumber).getCandidates().get(0);
                    backtracks.push(new Backtrack(board.copyBoard(), fieldNumber, chosenCandidate));
                    board.getFieldByFieldNumber(fieldNumber).setValue(chosenCandidate);
                    board.getFieldByFieldNumber(fieldNumber).getCandidates().clear();
                    board.getFieldByFieldNumber(fieldNumber).getCandidates().add(chosenCandidate);
                    board.removeCandidateFromRowColumnSection(fieldNumber);
                    solved = false;
                } else {
                    if (backtracks.size() == 0) {
                        solved = true;
                        solvedCorrect = false;
                    } else {
                        Backtrack b = backtracks.pop();
                        board = b.getBoard();
                        board.getFieldByFieldNumber(b.getFieldNumber()).getCandidates().remove(0);
                        solved = false;
                    }
                }
            } else {
                solved = true;
                solvedCorrect = true;
            }
        }
    }
}