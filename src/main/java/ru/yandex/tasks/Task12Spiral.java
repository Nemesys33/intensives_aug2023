package ru.yandex.tasks;

import java.util.Arrays;

public class Task12Spiral {
    public static int[][] draw (int N) {
        /*
         * Отрисовывает "спираль" в двумерном массиве по часовой стрелке
         * -10^3 <= N <= 10^3
         * Выход: массив со спиралью
         */
        // (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ WRITE CODE HERE (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
        int[][] ans = new int[N][N];
        int[][] visited = new int[N][N];
        int w = 0, h = 0;
        while(w < N) {
            ans[h][w] = w+1;
            visited[h][w] = 1;
            w++;
        }
        w--;
        for (int i = N + 1; i <= N * N;) {
            var up = (h > 0 && visited[h-1][w] == 0);
            var down = (h < N - 1 && visited[h+1][w] == 0);
            var left = (w > 0 && visited[h][w-1] == 0);

            if(up){
                while(h > 0 && visited[h-1][w] == 0){
                    h--;
                    ans[h][w] = i++;
                    visited[h][w] = 1;
                }
            } else if(down){
                while(h < N- 1 && visited[h + 1][w] == 0){
                    h++;
                    ans[h][w] = i++;
                    visited[h][w] = 1;
                }
            }else if(left){
                while(w > 0 && visited[h][w - 1] == 0){
                    w--;
                    ans[h][w] = i++;
                    visited[h][w] = 1;
                }
            } else{ // right
                while(w < N - 1 && visited[h][w + 1] == 0){
                    w++;
                    ans[h][w] = i++;
                    visited[h][w] = 1;
                }
            }
        }
        return ans;
    }

    public static void selfCheck() {
        int[][] output = {
                {1, 2, 3, 4, 5, 6, 7},
                {24, 25, 26, 27, 28, 29, 8},
                {23, 40, 41, 42, 43, 30, 9},
                {22, 39, 48, 49, 44, 31, 10},
                {21, 38, 47, 46, 45, 32, 11},
                {20, 37, 36, 35, 34, 33, 12},
                {19, 18, 17, 16, 15, 14, 13}
        };

        assert Arrays.deepEquals(output, draw(7));
    }
}
