package src.programmers.lv3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem22 {

    public int solution(int[][] board) {
        int n = board.length;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int[][][] cost = new int[n][n][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        pq.add(new Node(0, 0, -1, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.row == n - 1 && now.col == n - 1) {
                return now.cost;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nextRow = now.row + dx[dir];
                int nextCol = now.col + dy[dir];

                if (!isValid(nextRow, nextCol, n)) continue;
                if (board[nextRow][nextCol] == 1) continue;

                int nextCost = now.cost + 100;

                if (now.dir != -1 && now.dir != dir) {
                    nextCost += 500;
                }

                if (cost[nextRow][nextCol][dir] > nextCost) {
                    cost[nextRow][nextCol][dir] = nextCost;
                    pq.add(new Node(nextRow, nextCol, dir, nextCost));
                }
            }
        }

        return 0;
    }

    private boolean isValid(int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    class Node {
        int row;
        int col;
        int dir;
        int cost;

        public Node(int row, int col, int dir, int cost) {
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.cost = cost;
        }
    }
}