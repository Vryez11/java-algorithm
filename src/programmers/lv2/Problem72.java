package src.programmers.lv2;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem72 {

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};
    char[][] map;

    // 무인도 여행
    public int[] solution(String[] maps) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        map = new char[maps.length][maps[0].length()];
        for (int i = 0; i < map.length; i++) {
            map[i] = maps[i].toCharArray();
        }

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (map[i][j] == 'X') continue;

                int surviveDay = 0;
                Queue<Index> queue = new LinkedList<>();
                queue.add(new Index(i, j));
                surviveDay += Integer.parseInt(String.valueOf(map[i][j]));
                map[i][j] = 'X';

                while (!queue.isEmpty()) {
                    Index now = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int nextY = now.y + dy[k];
                        int nextX = now.x + dx[k];

                        if (isValid(nextY, nextX) && map[nextY][nextX] != 'X') {
                            queue.add(new Index(nextY, nextX));
                            surviveDay += Integer.parseInt(String.valueOf(map[nextY][nextX]));
                            map[nextY][nextX] = 'X';
                        }
                    }
                }
                pq.add(surviveDay);
            }
        }
        if (pq.isEmpty()) return new int[]{-1};

        int size = pq.size();
        int[] answer = new int[pq.size()];
        for (int i = 0; i < size; i++) {
            answer[i] = pq.poll();
        }

        return answer;
    }

    private boolean isValid(int y, int x) {
        return y < map.length && y >= 0 && x < map[0].length && x >= 0;
    }

    static class Index {
        int y;
        int x;

        public Index(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
