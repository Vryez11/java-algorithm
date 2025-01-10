package src.programmers.lv1;

import java.util.Arrays;

public class Problem47 {

    public int solution(int k, int m, int[] score) {

        int boxCount = score.length / m;
        int maxSum = 0;
        int min = k;

        Arrays.sort(score);

        for (int i = 0; i < boxCount; i++) {
            for (int j = 0; j < m; j++) {
                min = Math.min(score[score.length - 1 - i * m - j], min);
            }
            maxSum += min * m;
        }

        return maxSum;
    }
}
