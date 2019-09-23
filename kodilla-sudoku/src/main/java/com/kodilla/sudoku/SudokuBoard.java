package com.kodilla.sudoku;

import java.util.*;

import static com.kodilla.sudoku.SudokuField.EMPTY;

public class SudokuBoard {

    private SudokuField[] board = new SudokuField[81];

    SudokuField[] getBoard() {
        return board;
    }

    SudokuField getFieldByFieldNumber(int fieldNumber) {
        return board[fieldNumber];
    }

    void createBoard() {
        for (int i = 0; i < board.length; i++) {
            board[i] = new SudokuField();
            board[i].setValue(EMPTY);
            board[i].setRow(i / 9 + 1);
            board[i].setFieldNumber(i);
            board[i].setColumn(i % 9 + 1);
            board[i].setSection((((board[i].getRow() - 1) / 3) * 3 + (board[i].getColumn() - 1) / 3) + 1);
        }
    }

    SudokuBoard copyBoard() {
        SudokuBoard copy = new SudokuBoard();
        for (int i = 0; i < this.board.length; i++) {
            copy.board[i] = this.board[i].copyField();
        }
        return copy;
    }

    int firstFieldWithTheLeastCandidates() {
        for (int i = 2; i < 10; i++) {
            for (SudokuField field : board) {
                if (field.getCandidates().size() == i) {
                    return field.getFieldNumber();
                }
            }
        }
        return 0;
    }

    boolean isFilled() {
        for (SudokuField field : board) {
            if (field.getValue() == EMPTY) {
                return false;
            }
        }
        return true;
    }

    boolean hasFieldWithNoCandidates() {
        for (SudokuField field : board) {
            if (field.getCandidates().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    boolean isFilledCorrect() {
        Set<Integer> sR = new HashSet<>();
        Set<Integer> sC = new HashSet<>();
        Set<Integer> sS = new HashSet<>();

        if (!this.isFilled()) {
            return false;
        }

        for (int i = 1; i < 10; i++) {
            for (SudokuField field : board) {
                if (field.getRow() == i) {
                    sR.add(field.getValue());
                }
                if (field.getColumn() == i) {
                    sC.add(field.getValue());
                }
                if (field.getSection() == i) {
                    sS.add(field.getValue());
                }
            }
            if ((sR.size() != 9 || sC.size() != 9 || sS.size() != 9)) {
                return false;
            }
            sR.clear();
            sC.clear();
            sS.clear();
        }
        return true;
    }

    private boolean isSingleCandidateOnPosition(SudokuField fieldI, SudokuField fieldJ){
        return (fieldI.getRow() == fieldJ.getRow()
                || fieldI.getColumn() == fieldJ.getColumn()
                || fieldI.getSection() == fieldJ.getSection()
                && fieldJ.getValue() != 0);
    }

    private boolean isCandidateOnSinglePosition(List<Integer> listForRows, List<Integer> listForColumns, List<Integer> listForSections,
                                                SudokuField field,  int i, int j) {
        return (field.getValue() == EMPTY && field.getCandidates().contains(j)
                && (listForRows.contains(j) && listForRows.indexOf(j) == listForRows.lastIndexOf(j) && field.getRow() == i
                || listForColumns.contains(j) && listForColumns.indexOf(j) == listForColumns.lastIndexOf(j) && field.getColumn() == i
                || listForSections.contains(j) && listForSections.indexOf(j) == listForSections.lastIndexOf(j) && field.getSection() == i));
    }

    void removeCandidateFromRowColumnSection(int filledFieldIndex) {
        for (SudokuField field : board) {
            if (field.getValue() == EMPTY &&
                    field.getCandidates().contains(board[filledFieldIndex].getValue())) {
                if (board[filledFieldIndex].getRow() == field.getRow()
                        || board[filledFieldIndex].getColumn() == field.getColumn()
                        || board[filledFieldIndex].getSection() == field.getSection()) {
                    field.getCandidates().remove((Integer) board[filledFieldIndex].getValue());
                }
            }
        }
    }

    boolean singleCandidate() {
        boolean noAction = true;
        for (SudokuField fieldI : board) {
            if (fieldI.getValue() == EMPTY) {
                if (fieldI.getCandidates().size() == 1) {
                    fieldI.setValue(fieldI.getCandidates().get(0));
                    removeCandidateFromRowColumnSection(fieldI.getFieldNumber());
                    noAction = false;
                } else {
                    for (SudokuField fieldJ : board) {
                        if (isSingleCandidateOnPosition(fieldI, fieldJ)) {
                            if (fieldI.getCandidates().remove((Integer) fieldJ.getValue())) {
                                noAction = false;
                            }
                        }
                    }
                    if (fieldI.getCandidates().size() == 1) {
                        fieldI.setValue(fieldI.getCandidates().get(0));
                        removeCandidateFromRowColumnSection(fieldI.getFieldNumber());
                        noAction = false;
                    }
                }
            }
        }
        return noAction;
    }

    boolean singlePosition() {
        boolean noAction = true;
        List<Integer> listForRows = new ArrayList<>();
        List<Integer> listForColumns = new ArrayList<>();
        List<Integer> listForSections = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            for (SudokuField field : board) {
                if (field.getValue() == EMPTY && field.getRow() == i) {
                    listForRows.addAll(field.getCandidates());
                }
                if (field.getValue() == EMPTY && field.getColumn() == i) {
                    listForColumns.addAll(field.getCandidates());
                }
                if (field.getValue() == EMPTY && field.getSection() == i) {
                    listForSections.addAll(field.getCandidates());
                }
            }
            for (int j = 1; j < 10; j++) {
                for (SudokuField field : board) {
                    if (isCandidateOnSinglePosition(listForRows, listForColumns, listForSections, field, i, j)) {
                        field.setValue(j);
                        field.getCandidates().clear();
                        field.getCandidates().add(j);
                        removeCandidateFromRowColumnSection(field.getFieldNumber());
                        noAction = false;
                    }
                }
            }
            listForRows.clear();
            listForColumns.clear();
            listForSections.clear();
        }
        return noAction;
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
