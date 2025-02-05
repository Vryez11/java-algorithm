package src.programmers.lv2;

import java.util.PriorityQueue;

public class Problem41 {

    // 더 멥게
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int food : scoville) {
            pq.add(food);
        }

        int count = 0;
        while (!pq.isEmpty() && pq.peek() < K) {
            count++;
            Integer food = pq.poll();
            if (pq.isEmpty()) return -1;
            Integer hotter = pq.poll();

            pq.add(food + (hotter * 2));
        }
        return count;
    }
}
