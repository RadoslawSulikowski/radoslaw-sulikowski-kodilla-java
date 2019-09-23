package com.kodilla.sudoku;

public class SolverRunner {

    public static void main(String[] args) {

        SudokuSolver solver = new SudokuSolver(SampleBoards.sampleBoard10());

        solver.solve();

        System.out.println(solver.getBoard().toString());

        System.out.println("Correct: " + solver.getBoard().isFilledCorrect());
        System.out.println("Field with no candidates: " + solver.getBoard().hasFieldWithNoCandidates());
    }
}
