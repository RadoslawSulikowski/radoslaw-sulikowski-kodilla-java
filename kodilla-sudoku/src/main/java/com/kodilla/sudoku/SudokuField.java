package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;


public class SudokuField {
    public static final int EMPTY = 0;
    private int value;
    private int row;
    private int column;
    private int section;
    private int fieldNumber;
    private boolean userValue;
    private List<Integer> candidates = new ArrayList<>();

    public SudokuField() {
        for (int i = 1; i < 10; i++) {
            candidates.add(i);
        }
    }

    public int getValue() {
        return value;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getSection() {
        return section;
    }

    public int getFieldNumber() {
        return fieldNumber;
    }

    public boolean isUserValue() {
        return userValue;
    }

    public List<Integer> getCandidates() {
        return candidates;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public void setFieldNumber(int fieldNumber) {
        this.fieldNumber = fieldNumber;
    }

    public void setUserValue(boolean userValue) {
        this.userValue = userValue;
    }
}
