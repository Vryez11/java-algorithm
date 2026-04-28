package src.programmers.lv3;

import java.util.*;

public class Problem19 {

    // 부대복귀
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        List<Integer>[] lists = new List[n + 1];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int s = road[0];
            int e = road[1];

            lists[s].add(e);
            lists[e].add(s);
        }

        int[] results = new int[n + 1];
        boolean[] used = new boolean[n + 1];
        used[destination] = true;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(destination, 0));

        while(!queue.isEmpty()) {
            Node now = queue.poll();

            for (Integer next : lists[now.source]) {

                if (!used[next]) {
                    used[next] = true;
                    results[next] = now.depth + 1;
                    queue.offer(new Node(next, now.depth + 1));
                }
            }
        }

        int[] ans = new int[sources.length];
        for (int i = 0; i < ans.length; i++) {
            if (sources[i] == destination) {
                ans[i] = 0;
                continue;
            }

            ans[i] = results[sources[i]] > 0 ? results[sources[i]] : -1;
        }

        return ans;
    }

    class Node {
        int source;
        int depth;

        public Node(int source, int depth) {
            this.source = source;
            this.depth = depth;
        }
    }
}
