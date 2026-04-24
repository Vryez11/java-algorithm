package src.programmers.lv3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Problem17 {

    List<Integer>[] lists;

    // 가장 먼 노드
    public int solution(int n, int[][] edge) {

        lists = new List[n + 1];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int s = edge[i][0];
            int e = edge[i][1];

            lists[s].add(e);
            lists[e].add(s);
        }

        int[] dist = new int[n + 1];
        bfs(1, dist);

        int max = 0;
        int count = 0;
        for (int i = 1; i < dist.length; i++) {
            max = Math.max(max, dist[i]);
        }
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == max)
                count++;
        }

        return count;
    }

    private void bfs(int start, int[] dist) {

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {

            Node now = queue.poll();
            for (Integer next : lists[now.index]) {
                if (next == 1) continue;

                if (dist[next] == 0) {
                    dist[next] = now.depth + 1;
                    queue.offer(new Node(next, now.depth + 1));
                }
            }
        }
    }

    class Node {
        int index;
        int depth;

        public Node(int index, int depth) {
            this.index = index;
            this.depth = depth;
        }
    }
}
