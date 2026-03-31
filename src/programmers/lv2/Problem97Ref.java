package src.programmers.lv2;

import java.util.Arrays;

public class Problem97Ref {

    // 요격 시스템
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int count = 0;
        int lastX = -1;

        for (int[] target : targets) {
            int s = target[0];
            int e = target[1];

            if (lastX <= s) {
                count++;
                lastX = e;
            } else {
                lastX = Math.min(lastX, e);
            }
        }

        return count;
    }
}