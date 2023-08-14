package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class Task3InsertionSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> numbers) {
        /*
         * numbers: массив целых чисел, -10^5 <= numbers[i] <= 10^5, длина массива до 10^5
         * Выход: отсортированный (сортировкой вставками!) numbers
         */
        // (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ WRITE CODE HERE (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(numbers.get(0));
        for(int j = 1; j < numbers.size(); j++){
            boolean added = false;
            for (int i = 0; i < ans.size(); i++) {
                if(ans.get(i) > numbers.get(j)) {
                    ans.add(i, numbers.get(j));
                    added = true;
                    break;
                }
            }
            if(!added) ans.add(numbers.get(j));
        }
        return ans;
    }

    public static void selfCheck() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 4, 5, 2, 1));
        ArrayList<Integer> output = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        assert output.equals(sort(input));
    }
}
