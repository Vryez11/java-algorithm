package src.programmers.lv2;

import java.util.*;

public class Problem68 {

    // 미로 탈출
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] map;

    static class Index {
        int y, x, count;
        public Index(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    public int solution(String[] maps) {
        int startY = 0, startX = 0, leverY = 0, leverX = 0;

        map = new char[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                map[i][j] = maps[i].charAt(j);
                if (map[i][j] == 'S') {
                    startY = i; startX = j;
                } else if (map[i][j] == 'L') {
                    leverY = i; leverX = j;
                }
            }
        }

        // S → L 거리 구하기
        int toLever = bfs(startY, startX, 'L');
        if (toLever == -1) return -1;

        // L → E 거리 구하기
        int toExit = bfs(leverY, leverX, 'E');
        if (toExit == -1) return -1;

        return toLever + toExit;
    }

    private int bfs(int startY, int startX, char target) {
        Queue<Index> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[map.length][map[0].length];

        queue.add(new Index(startY, startX, 0));
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            Index now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = now.y + dy[i];
                int nextX = now.x + dx[i];

                if (isValid(nextY, nextX) && !visited[nextY][nextX] && map[nextY][nextX] != 'X') {
                    if (map[nextY][nextX] == target) {
                        return now.count + 1;
                    }
                    queue.add(new Index(nextY, nextX, now.count + 1));
                    visited[nextY][nextX] = true;
                }
            }
        }
        return -1;
    }

    private boolean isValid(int y, int x) {
        return y >= 0 && y < map.length && x >= 0 && x < map[0].length;
    }
}
