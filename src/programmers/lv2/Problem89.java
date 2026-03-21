package src.programmers.lv2;

import java.util.*;

public class Problem89 {

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();

        char[][] map = new char[n + 2][m + 2];

        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(map[i], '.');
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i + 1][j + 1] = storage[i].charAt(j);
            }
        }

        for (String request : requests) {
            char target = request.charAt(0);

            if (request.length() == 2) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (map[i][j] == target) {
                            map[i][j] = '.';
                        }
                    }
                }
            } else {
                remove(map, target);
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] != '.') {
                    count++;
                }
            }
        }

        return count;
    }

    private void remove(char[][] map, char target) {
        int h = map.length;
        int w = map[0].length;

        boolean[][] visited = new boolean[h][w];
        Queue<int[]> q = new LinkedList<>();
        List<int[]> removeList = new ArrayList<>();

        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w || visited[nx][ny]) {
                    continue;
                }

                if (map[nx][ny] == '.') {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                } else if (map[nx][ny] == target) {
                    visited[nx][ny] = true;
                    removeList.add(new int[]{nx, ny});
                }
            }
        }

        for (int[] pos : removeList) {
            map[pos[0]][pos[1]] = '.';
        }
    }
}