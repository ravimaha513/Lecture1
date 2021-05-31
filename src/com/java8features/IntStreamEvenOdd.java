package com.java8features;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class IntStreamEvenOdd {

    public static void main(String[] args) {
        String[] words = {"Ravi", "teja"};
        StringBuilder result = new StringBuilder();
        for(String word : words){
            result.append(reindex(word));
        }

        System.out.println(result.toString());

    }

    private static String reindex(String input) {
        StringBuilder result = new StringBuilder(input.length() + 1);
        result.append(filter(input, index -> index % 2 == 0));
        result.append(' ');
        result.append(filter(input, index -> index % 2 == 1));
        return result.toString();
    }

    private static StringBuilder filter(String input, IntPredicate predicate) {
        return IntStream.range(0, input.length())
                .filter(predicate)
                .map(input::charAt)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);
    }
}
