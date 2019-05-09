package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OddNumbersExterminator {
    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers){

        ArrayList<Integer> list = new ArrayList<>();
        if(numbers.isEmpty()){
            return numbers;
        }else {
            list.addAll(numbers);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) % 2 == 1) {
                    list.remove(list.get(i));
                    i--;
                }
            }
        }
        return list;
    }
}
