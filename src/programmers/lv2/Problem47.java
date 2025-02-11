package src.programmers.lv2;

import java.util.*;

public class Problem47 {

    public int solution(int x, int y, int n) {
        if (x == y) return 0;

        Queue<Depth> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(new Depth(x, 0));
        visited.add(x);

        while (!queue.isEmpty()) {
            Depth cur = queue.poll();
            int curNumber = cur.number;
            int curDepth = cur.depth;

            for (int next : new int[]{curNumber + n, curNumber * 2, curNumber * 3}) {
                if (next == y) return curDepth + 1;
                if (next <= y && !visited.contains(next)) {
                    queue.add(new Depth(next, curDepth + 1));
                    visited.add(next);
                }
            }
        }
        return -1;
    }

    static class Depth {
        int number;
        int depth;

        public Depth(int number, int depth) {
            this.number = number;
            this.depth = depth;
        }
    }
}
