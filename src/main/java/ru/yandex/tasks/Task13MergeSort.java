package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class Task13MergeSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> numbers) {
        /*
         * numbers: массив целых чисел, -10^5 <= numbers[i] <= 10^5, длина массива до 10^5
         * Выход: отсортированный (сортировкой слиянием!) numbers
         */
        // (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ WRITE CODE HERE (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
        if(numbers.size() == 1) return numbers;
        return merge(sort(new ArrayList<>(numbers.subList(0, numbers.size()/2))),
                sort(new ArrayList<>(numbers.subList(numbers.size()/2, numbers.size()))));
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> n1, ArrayList<Integer> n2) {
        int f = 0, s = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while(f < n1.size() || s < n2.size()){
            if(f == n1.size()) res.add(n2.get(s++));
            else if(s == n2.size()) res.add(n1.get(f++));
            else {
                if(n1.get(f) < n2.get(s)){
                    res.add(n1.get(f++));
                } else{
                    res.add(n2.get(s++));
                }
            }

        }
        return res;
    }

    public static void selfCheck() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 4, 5, 2, 1));
        ArrayList<Integer> output = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        assert output.equals(sort(input));
    }
}
