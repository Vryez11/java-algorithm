package src.programmers.lv3;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem3 {

    // 네트워크 - BFS
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int networkCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, n, computers, visited);
                networkCount++;
            }
        }

        return networkCount;
    }

    private void bfs(int start, int n, int[][] computers, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next = 0; next < n; next++) {
                if (now == next) continue;

                if (computers[now][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}