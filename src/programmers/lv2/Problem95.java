package src.programmers.lv2;

public class Problem95 {

    boolean[] diag1Used;
    boolean[] diag2Used;
    boolean[] colUsed;
    int answer;

    // N-Queen
    public int solution(int n) {
        answer = 0;

        colUsed = new boolean[n];
        diag1Used = new boolean[2 * n - 1];
        diag2Used = new boolean[2 * n - 1];

        dfs(0, n);

        return answer;
    }

    private void dfs(int row, int n) {

        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row + col;
            int d2 = row - col + (n - 1);

            if (colUsed[col] || diag1Used[d1] || diag2Used[d2]) continue;

            colUsed[col] = true;
            diag1Used[d1] = true;
            diag2Used[d2] = true;

            dfs(row + 1, n);

            colUsed[col] = false;
            diag1Used[d1] = false;
            diag2Used[d2] = false;
        }
    }
}
