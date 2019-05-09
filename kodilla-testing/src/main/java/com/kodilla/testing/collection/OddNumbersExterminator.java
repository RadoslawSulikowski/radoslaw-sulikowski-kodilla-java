package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {
    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers){

        if(numbers.isEmpty()){
            return numbers;
        }else {
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) % 2 == 1) {
                    numbers.remove(numbers.get(i));
                }
            }
        }
        return numbers;
    }
}
