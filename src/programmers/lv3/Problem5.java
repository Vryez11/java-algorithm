package src.programmers.lv3;

import java.util.PriorityQueue;

public class Problem5 {

    // 야근 지수
    public long solution(int n, int[] works) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int work : works) {
            pq.add(work);
        }

        while(!pq.isEmpty() && n > 0) {
            Integer now = pq.poll();
            n--;
            if (now - 1 == 0) continue;

            pq.offer(now - 1);
        }

        if (pq.isEmpty()) return 0;

        long piro = 0;
        while (!pq.isEmpty()) {
            Integer now = pq.poll();
            System.out.println(now);
            piro += (long) now * now;
        }

        return piro;
    }
}
