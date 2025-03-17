package src.programmers.lv2;

import java.util.PriorityQueue;

public class Problem79 {

    // 디펜스 게임
    public int solution(int n, int k, int[] enemies) {

        int round = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        for (int enemy : enemies) {
            if (n >= enemy) {
                n -= enemy;
                pq.offer(enemy);
            } else {
                if (k > 0) {
                    if (!pq.isEmpty() && pq.peek() > enemy) {
                        n += pq.poll();
                        n -= enemy;
                        pq.offer(enemy);
                    }
                    k--;
                } else {
                    break;
                }
            }
            round++;
        }

        return round;
    }
}
