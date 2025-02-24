package src.programmers.lv2;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem55 {

    // 두 큐 합 같게 만들기
    public int solution (int[] queue1, int[] queue2) {
        int count = 0;
        int maxCount = 2 * (queue1.length + queue2.length);

        long sum1 = 0, sum2 = 0, totalSum = 0;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        for (int num : queue1) {
            sum1 += num;
            q1.offer(num);
        }

        for (int num : queue2) {
            sum2 += num;
            q2.offer(num);
        }

        totalSum = sum1 + sum2;
        if (totalSum % 2 != 0) return -1;

        long target = totalSum / 2;

        while (count <= maxCount) {
            if (sum1 == target) return count;

            if (sum1 > target && !q1.isEmpty()) {
                int num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.offer(num);
            } else if (sum1 < target && !q2.isEmpty()) {
                int num = q2.poll();
                sum2 -= num;
                sum1 += num;
                q1.offer(num);
            } else {
                return -1;
            }
            count++;
        }
        return -1;
    }
}
