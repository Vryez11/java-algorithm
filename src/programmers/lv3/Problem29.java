package src.programmers.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem29 {

    // 인사고과
    public int solution(int[][] scores) {
        if (scores.length == 1) return 1;

        int attitude = scores[0][0];
        int pear = scores[0][1];
        int sum = attitude + pear;
        int ans = 0;

        int[][] newScores = new int[scores.length - 1][2];
        for (int i = 0; i < newScores.length; i++) {
            for (int j = 0; j < 2; j++) {
                newScores[i][j] = scores[i + 1][j];
            }
        }
        Arrays.sort(newScores, (a, b) -> (b[0] + b[1]) - (a[0] + a[1]));

        List<Score> list = new ArrayList<>();
        for (int[] score : newScores) {
            int otherAttitude = score[0];
            int otherPear = score[1];
            int otherSum = otherAttitude + otherPear;
            boolean flag = false;

            if (sum >= otherSum) break;

            list.add(new Score(otherAttitude, otherPear));

            for (Score score1 : list) {
                if (otherAttitude < score1.attitude && otherPear < score1.pear) {
                    flag = true;
                    break;
                }

                if (attitude < score1.attitude && pear < score1.pear) {
                    return -1;
                }
            }

            if (flag) continue;

            ans++;
        }

        return ans + 1;
    }

    class Score {
        int attitude;
        int pear;

        public Score(int attitude, int pear) {
            this.attitude = attitude;
            this.pear = pear;
        }
    }
}
