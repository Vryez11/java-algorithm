package src.programmers.lv2;

import java.util.*;

public class Problem92 {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    // [PCCP 기출문제] 2번 / 석유 시추
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        int[][] group = new int[n][m];
        List<Integer> groupSize = new ArrayList<>();
        groupSize.add(0);

        int groupId = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && group[i][j] == 0) {
                    int size = bfs(i, j, land, group, groupId);
                    groupSize.add(size);
                    groupId++;
                }
            }
        }

        int answer = 0;

        for (int col = 0; col < m; col++) {
            Set<Integer> set = new HashSet<>();
            int sum = 0;

            for (int row = 0; row < n; row++) {
                if (group[row][col] != 0) {
                    set.add(group[row][col]);
                }
            }

            for (int id : set) {
                sum += groupSize.get(id);
            }

            answer = Math.max(answer, sum);
        }

        return answer;
    }

    private int bfs(int startRow, int startCol, int[][] land, int[][] group, int groupId) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(startRow, startCol));
        group[startRow][startCol] = groupId;

        int count = 1;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nextRow = now.row + dx[d];
                int nextCol = now.col + dy[d];

                if (!isValid(nextRow, nextCol, land)) continue;
                if (land[nextRow][nextCol] == 0) continue;
                if (group[nextRow][nextCol] != 0) continue;

                group[nextRow][nextCol] = groupId;
                queue.offer(new Node(nextRow, nextCol));
                count++;
            }
        }

        return count;
    }

    private boolean isValid(int row, int col, int[][] land) {
        return row >= 0 && row < land.length && col >= 0 && col < land[0].length;
    }

    class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}