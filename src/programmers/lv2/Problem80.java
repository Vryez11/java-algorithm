package src.programmers.lv2;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem80 {

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    // 거리두기 확인하기
    public int[] solution(String[][] places) {
        int[] result = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            result[i] = checkDistance(places[i]) ? 1 : 0;
        }
        return result;
    }

    private boolean checkDistance(String[] place) {
        for (int y = 0; y < place.length; y++) {
            for (int x = 0; x < place[y].length(); x++) {
                if (place[y].charAt(x) == 'P') {
                    if (!bfs(place, y, x)) return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(String[] place, int startY, int startX) {
        Queue<Index> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[place.length][place[0].length()];
        queue.offer(new Index(startY, startX, 0));
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            Index now = queue.poll();
            int nowX = now.indexX;
            int nowY = now.indexY;

            for (int i = 0; i < 4; i++) {
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];
                int depth = now.depth + 1;

                if (depth > 2) continue;
                if (!isValid(nextY, nextX, place)) continue;
                if (visited[nextY][nextX]) continue;
                if (place[nextY].charAt(nextX) == 'X') continue;
                if (place[nextY].charAt(nextX) == 'P') return false;

                visited[nextY][nextX] = true;
                queue.offer(new Index(nextY, nextX, depth));
            }
        }
        return true;
    }

    private boolean isValid(int y, int x, String[] place) {
        return y >= 0 && y < place.length && x >= 0 && x < place[0].length();
    }

    static class Index {
        int indexY;
        int indexX;
        int depth;

        public Index(int indexY, int indexX, int depth) {
            this.indexY = indexY;
            this.indexX = indexX;
            this.depth = depth;
        }
    }
}
