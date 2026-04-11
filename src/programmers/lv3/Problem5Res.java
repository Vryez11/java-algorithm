package src.programmers.lv3;

import java.util.Arrays;

class Problem5Res {

    // 야근 지수 - 이분 탐색 풀이
    public long solution(int n, int[] works) {

        long sum = 0;
        int max = 0;

        for (int work : works) {
            sum += work;
            max = Math.max(max, work);
        }

        if (sum <= n) return 0;

        int left = 0;
        int right = max;

        while (left < right) {
            int mid = (left + right) / 2;

            long need = 0;

            for (int work : works) {
                if (work > mid) {
                    need += (work - mid);
                }
            }

            if (need > n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        long answer = 0;
        long remain = n;

        for (int i = 0; i < works.length; i++) {
            if (works[i] > left) {
                remain -= (works[i] - left);
                works[i] = left;
            }
        }

        Arrays.sort(works);

        for (int i = works.length - 1; i >= 0 && remain > 0; i--) {
            if (works[i] > 0) {
                works[i]--;
                remain--;
            }
        }

        for (int work : works) {
            answer += (long) work * work;
        }

        return answer;
    }
}