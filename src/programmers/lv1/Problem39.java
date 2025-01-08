package src.programmers.lv1;

import java.util.Arrays;

public class Problem39 {

    public int[] solution(int k, int[] score) {
        int[] own = new int[k];
        int[] res = new int[score.length];

        for (int i = 0; i < k; i++) {
            if (i >= score.length) {
                break;
            }
            own[0] = score[i];
            Arrays.sort(own);
            res[i] = own[k - i - 1];
        }

        for (int i = k; i < score.length; i++) {
            if (score[i] > own[0]) {
                own[0] = score[i];
            }
            Arrays.sort(own);
            res[i] = own[0];
        }

        return res;
    }
}
