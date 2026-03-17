package src.programmers.lv2;

public class Problem86 {

    //[PCCP 기출문제] 2번 / 퍼즐 게임 챌린지
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        int answer = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canSolve(diffs, times, limit, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean canSolve(int[] diffs, int[] times, long limit, int level) {
        long total = times[0];

        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                total += times[i];
            } else {
                long mistakes = diffs[i] - level;
                total += mistakes * (times[i] + times[i - 1]) + times[i];
            }

            if (total > limit) {
                return false;
            }
        }

        return total <= limit;
    }
}