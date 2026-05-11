package src.programmers.lv3;

import java.util.Arrays;

class Problem29Res {

    // 인사고과
    public int solution(int[][] scores) {

        int wanhoA = scores[0][0];
        int wanhoB = scores[0][1];
        int wanhoSum = wanhoA + wanhoB;

        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        int rank = 1;
        int maxPeer = 0;

        for (int[] score : scores) {
            int attitude = score[0];
            int peer = score[1];
            int sum = attitude + peer;

            if (peer < maxPeer) {
                if (attitude == wanhoA && peer == wanhoB) {
                    return -1;
                }
                continue;
            }

            maxPeer = Math.max(maxPeer, peer);

            if (sum > wanhoSum) {
                rank++;
            }
        }

        return rank;
    }
}
