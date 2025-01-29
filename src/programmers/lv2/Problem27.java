package src.programmers.lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem27 {

    private int[][] dungeons;
    private boolean[] visited;

    // 피로도
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;

        return bfs(k);
    }

    private int bfs (int currentHp) {
        Queue<dungeon> queue = new LinkedList<>();
        queue.add(new dungeon(currentHp, 0, new boolean[dungeons.length]));
        int maxDepth = 0;

        while (!queue.isEmpty()) {
            dungeon now = queue.poll();

            for (int i = 0; i < dungeons.length; i++) {
                int hp = now.currentHp;
                int depth = now.depth;
                boolean[] visited = Arrays.copyOf(now.visited, dungeons.length);

                if (hp >= dungeons[i][0] && !visited[i]) {
                    visited[i] = true;
                    hp -= dungeons[i][1];
                    queue.add(new dungeon(hp, depth + 1, visited));
                }
            }
            maxDepth = Math.max(maxDepth, now.depth);
        }
        return maxDepth;
    }

    class dungeon {
        private int currentHp;
        private int depth;
        private boolean[] visited;

        public dungeon(int currentHp, int depth, boolean[] visited) {
            this.currentHp = currentHp;
            this.depth = depth;
            this.visited = visited;
        }

        @Override
        public String toString() {
            return "dungeon{" +
                    "currentHp=" + currentHp +
                    ", depth=" + depth +
                    ", visited=" + Arrays.toString(visited) +
                    '}';
        }
    }
}
