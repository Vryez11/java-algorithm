package src.programmers.lv2;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem66 {

    // 서버 증설 획수
    public int solution(int[] players, int m, int k) {
        int count = 0;
        int totalPlayers = m - 1;
        int hour = 0;

        Queue<Integer> q = new ArrayDeque<>();

        for (int total : players) {
            while (!q.isEmpty() && q.peek() == hour) {
                q.poll();
            }
            totalPlayers = (m - 1) + (q.size() * m);

            while (totalPlayers < total) {
                q.offer(hour + k);
                totalPlayers = (m - 1) + (q.size() * m);
                count++;
            }

            hour++;
        }

        return count;
    }
}
