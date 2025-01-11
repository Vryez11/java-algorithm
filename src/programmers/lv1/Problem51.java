package src.programmers.lv1;

import java.util.Arrays;

public class Problem51 {

    public int[] solution(int N, int[] stages) {

        double[] failedArr = new double[N];
        int[] res = new int[N];
        int players = stages.length;

        StageInfo[] stageInfos = new StageInfo[N];
        for (int i = 0; i < N; i++) {
            stageInfos[i] = new StageInfo((i + 1));
        }
        for (int i = 0; i < stages.length; i++) {
            if (stages[i] == N + 1) continue;
            stageInfos[stages[i] - 1].playerNumber++;
        }
        for (int i = 0; i < N; i++) {
            if (players == 0) {
                stageInfos[i].failed = 0;
                continue;
            }
            stageInfos[i].failed = (double) stageInfos[i].playerNumber / players;
            players -= stageInfos[i].playerNumber;
            failedArr[i] = stageInfos[i].failed;
        }
        Arrays.sort(failedArr);
        for (int i = 0; i < failedArr.length; i++) {
            for (int j = 0; j < stageInfos.length; j++) {
                if (failedArr[failedArr.length - (i + 1)] == stageInfos[j].failed) {
                    res[i] = stageInfos[j].stageNumber;
                    stageInfos[j].failed = -1;
                    break;
                }
            }
        }

        return res;
    }

    private class StageInfo {

        private int stageNumber;
        public double failed;
        public int playerNumber = 0;

        public StageInfo(int stageNumber) {
            this.stageNumber = stageNumber;
        }
    }
}
