package src.programmers.lv2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Problem63 {

    boolean[] visited;
    List<Integer>[] tree;

    // 전력망을 둘로 나누기
    public int solution(int n, int[][] wires) {

        tree = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            tree[wire[0]].add(wire[1]);
            tree[wire[1]].add(wire[0]);
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            List<Integer> list = tree[i];
            if (list.size() == 1) continue;

            for (Integer now : list) {
                visited = new boolean[n + 1];

                int left = BFS(now, i);
                int right = BFS(i, now);

                result = Math.min(result, Math.abs(left - right));
            }
        }

        return result;
    }

    private int BFS(int inner, int outer) {
        Queue<Integer> q = new ArrayDeque<>();
        int count = 0;

        q.add(inner);
        visited[inner] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (Integer next : tree[now]) {
                if (!visited[next] && next != outer) {
                    q.add(next);
                    visited[next] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
