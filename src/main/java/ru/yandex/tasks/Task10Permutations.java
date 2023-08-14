package ru.yandex.tasks;

import java.util.*;

public class Task10Permutations {
    static List<int []> ansList = new ArrayList<>();
    static Set<Integer> used = new HashSet<>();
    public static int[][] permutations(int[] numbers) {
        /*
         * Возвращает массив со всеми перестановками массива numbers (до 10 элементов, все по модулю до 10^5)
         */
        // (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ WRITE CODE HERE (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
        // solution
        int[] permut = new int[numbers.length];
        permute(numbers, permut, 0);

        // make answer array
        int[][] answer = new int[ansList.size()][];
        int point = 0;
        for(var ar: ansList){
            answer[point++] = ar;
        }
        return answer;
    }

    public static void permute(int[] numbers, int[] permut, int level) {
        for (int i = 0; i < numbers.length; i++) {
            if(used.add(numbers[i])) {
                permut[level] = numbers[i];
                if (level == numbers.length - 1) ansList.add(Arrays.copyOf(permut, permut.length));
                if (level < numbers.length - 1)
                    permute(numbers, permut, level + 1);
                used.remove(numbers[i]);
            }
        }
    }

    public static void selfCheck() {
        int[] input = {1, 2, 3};
        int[][] output = {
                {1, 2, 3},
                {1, 3, 2},
                {2, 1, 3},
                {2, 3, 1},
                {3, 1, 2},
                {3, 2, 1}
        };
        System.out.println(Arrays.deepToString(permutations(input)));
        System.out.println(Arrays.deepToString(output));
        assert Arrays.deepEquals(output, permutations(input));
    }
}
