package ru.yandex.tasks;

public class Task11BiggestSubarraySum {

    public static Subarray find(int[] numbers) {
        /*
         * Находит подмассив (подряд идущие элементы массива) с наибольшей суммой элементов
         * numbers: массив целых чисел, -10^5 <= numbers[i] <= 10^5, длина массива до 10^5
         * Выход: Subarray
         */
        // (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ WRITE CODE HERE (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
        int max = Integer.MIN_VALUE;
        int sum = 0;
        Subarray subarray = new Subarray();
        int left = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            if(sum > max){
                max = sum;
                subarray.left = left;
                subarray.right = i + 1;
            }
            if(sum < 0){
                sum = 0;
                left = i + 1;
            }
        }
        return subarray;
    }

    public static void selfCheck() {
        int[] output = {1, 2, -5, 7, -1, 6};
        Subarray ans = find(output);

        assert ans != null;
        assert (ans.left == 3 && ans.right == 6);
    }
}
