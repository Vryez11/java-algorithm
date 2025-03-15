package src.programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Problem76 {

    boolean[][] visited;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int solution(String[] board) {
        int startX = 0, startY = 0;
        int goalX = 0, goalY = 0;
        visited = new boolean[board.length][board[0].length()];

        char[][] maps = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                maps[i][j] = board[i].charAt(j);
                if (maps[i][j] == 'R') {
                    startX = j;
                    startY = i;
                }
                if (maps[i][j] == 'G') {
                    goalX = j;
                    goalY = i;
                }
            }
        }

        Queue<Index> queue = new LinkedList<>();
        visited[startY][startX] = true;
        queue.add(new Index(startX, startY, 0));

        while (!queue.isEmpty()) {
            Index now = queue.poll();
            if (now.x == goalX && now.y == goalY) return now.moveCount;

            for (int i = 0; i < 4; i++) {
                int nextX = now.x;
                int nextY = now.y;

                while (isValid(nextX + dx[i], nextY + dy[i], maps) && maps[nextY + dy[i]][nextX + dx[i]] != 'D') {
                    nextX += dx[i];
                    nextY += dy[i];
                }

                if (!visited[nextY][nextX]) {
                    queue.add(new Index(nextX, nextY, now.moveCount + 1));
                    visited[nextY][nextX] = true;
                }
            }
        }
        return -1;
    }

    private boolean isValid(int x, int y, char[][] maps) {
        return x >= 0 && x < maps[0].length && y >= 0 && y < maps.length;
    }

    static class Index {
        int x, y, moveCount;
        public Index(int x, int y, int moveCount) {
            this.x = x;
            this.y = y;
            this.moveCount = moveCount;
        }
    }
}
