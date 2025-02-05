package src.programmers.lv2;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem43 {

    // 땅따먹기
    public int solution(int[][] land) {
        int rowLen = land.length;

        for (int i = 1; i < rowLen; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][1], Math.max(land[i - 1][0], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][0]));
        }

        return Math.max(land[rowLen - 1][0], Math.max(land[rowLen - 1][1], Math.max(land[rowLen - 1][2], land[rowLen - 1][3])));
    }
}
