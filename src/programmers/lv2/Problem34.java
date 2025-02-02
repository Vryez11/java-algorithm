package src.programmers.lv2;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem34 {

    private boolean[][] visited;
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, -1, 0, 1};

    // 게임 맵 최단거리
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];

        int result = BFS(maps);

        return result;
    }

    private int BFS(int[][] maps) {
        Queue<Node> queue = new ArrayDeque<>();
        visited[0][0] = true;
        if (maps[0][0] == 1)
            queue.add(new Node(0,0, 1));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];

                if (isValid(x, y, maps)) {
                    if (!visited[y][x] && maps[y][x] == 1) {
                        visited[y][x] = true;
                        queue.add(new Node(x, y, now.depth + 1));
                    }
                }
            }
            if (now.x == maps[0].length - 1 && now.y == maps.length - 1) {
                return now.depth;
            }
        }
        return -1;
    }

    private static boolean isValid(int x, int y, int[][] maps) {
        return x >= 0 && x < maps[0].length && y >= 0 && y < maps.length;
    }

    private class Node {
        int x;
        int y;
        int depth;

        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
