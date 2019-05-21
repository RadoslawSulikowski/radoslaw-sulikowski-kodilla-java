package com.kodilla.stream.array;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface ArrayOperations{
    static double getAverage(int[] numbers){
        IntStream.range(0, numbers.length)
            .forEach(n -> System.out.print(numbers[n] + ", "));
        /* tak ładniej wyświetla
        System.out.println(IntStream.range(0, numbers.length)
                    .map(n -> numbers[n])
                    .mapToObj(Integer::toString)
                    .collect(Collectors.joining(", ", "[", "]")));
         */

        return IntStream.range(0, numbers.length)
                .map(n -> n =   numbers[n])
                .average().getAsDouble();
    }
}
