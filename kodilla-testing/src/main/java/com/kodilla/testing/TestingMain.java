package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args){

        Calculator calculator = new Calculator();

        int result = calculator.add(4, 8);

        if(result == (4 + 8)){
            System.out.println("test Calculator.add(a, b) method: OK!");
        } else {
            System.out.println("test Calculator.add(a, b) method: Something went wrong...");
        }

        result = calculator.subtract(547,403);

        if(result == (547 - 403)){
            System.out.println("test Calculator.subtract(minuend, subtrahend) method: OK!");
        } else {
            System.out.println("test Calculator.subtract(minuend, subtrahend) method: Something went wrong...");
        }
    }
}
