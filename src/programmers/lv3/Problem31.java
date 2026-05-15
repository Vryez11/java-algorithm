package src.programmers.lv3;

public class Problem31 {

    // 파괴되지 않는 건물
    public int solution(int[][] board, int[][] skill) {

        int n = board.length;
        int m = board[0].length;

        int[][] diff = new int[n + 1][m + 1];

        for (int[] action : skill) {
            int type = action[0];
            int r1 = action[1];
            int c1 = action[2];
            int r2 = action[3];
            int c2 = action[4];
            int degree = action[5];

            if (type == 1) {
                degree *= -1;
            }

            diff[r1][c1] += degree;
            diff[r1][c2 + 1] -= degree;
            diff[r2 + 1][c1] -= degree;
            diff[r2 + 1][c2 + 1] += degree;
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }

        for (int j = 0; j <= m; j++) {
            for (int i = 1; i <= n; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] + diff[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}