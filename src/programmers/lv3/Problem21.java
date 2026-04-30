package src.programmers.lv3;

import java.util.Arrays;

public class Problem21 {

    // 입국심사
    public long solution(int n, int[] times) {

        Arrays.sort(times);

        long left = 1;
        long right = (long) times[times.length - 1] * n;

        while (left <= right) {

            long mid = (left + right) / 2;
            long cnt = 0;

            for (int time : times) {
                cnt += mid / time;
            }

            if (cnt < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
