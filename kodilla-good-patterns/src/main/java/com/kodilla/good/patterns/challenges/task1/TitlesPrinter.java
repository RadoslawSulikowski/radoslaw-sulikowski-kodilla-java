package com.kodilla.good.patterns.challenges.task1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TitlesPrinter {
    public static void main(String[] args) {

        MovieStore store = new MovieStore();

        Map<String, List<String>> movies = store.getMovies();

        String titlesToPrint = movies.entrySet().stream()
        .flatMap(m -> m.getValue().stream())
                .collect(Collectors.joining("!"));

        System.out.println(titlesToPrint);

    }
}
