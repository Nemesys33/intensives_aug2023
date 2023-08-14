package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class Task1BubbleSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 1; j < numbers.size(); j++) {
                if(numbers.get(j-1) > numbers.get(j)){
                    var temp = numbers.get(j-1);
                    numbers.set(j-1, numbers.get(j));
                    numbers.set(j, temp);
                }
            }
        }
        return numbers;
    }

    public static void selfCheck() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 4, 5, 2, 1));
        ArrayList<Integer> output = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(sort(input));
        assert output.equals(sort(input));
    }
}
