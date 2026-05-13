package src.programmers.lv3;

import java.util.*;

class Problem30 {

    // 순위
    public int solution(int n, int[][] results) {
        List<Integer>[] winGraph = new ArrayList[n + 1];
        List<Integer>[] loseGraph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            winGraph[i] = new ArrayList<>();
            loseGraph[i] = new ArrayList<>();
        }

        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];

            winGraph[winner].add(loser);
            loseGraph[loser].add(winner);
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int winCount = bfs(winGraph, i, n);
            int loseCount = bfs(loseGraph, i, n);

            if (winCount + loseCount == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    private int bfs(List<Integer>[] graph, int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();

        visited[start] = true;
        queue.offer(start);

        int count = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }

        return count;
    }
}
