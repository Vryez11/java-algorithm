package src.programmers.lv2;

public class Problem90Res {

    int answer = 0;
    int[] selected = new int[5];

    public int solution(int n, int[][] q, int[] ans) {
        dfs(n, 1, 0, q, ans);
        return answer;
    }

    private void dfs(int n, int start, int depth, int[][] q, int[] ans) {
        if (depth == 5) {
            if (isValid(q, ans)) {
                answer++;
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            selected[depth] = i;
            dfs(n, i + 1, depth + 1, q, ans);
        }
    }

    private boolean isValid(int[][] q, int[] ans) {
        for (int i = 0; i < q.length; i++) {
            int count = 0;

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (selected[j] == q[i][k]) {
                        count++;
                    }
                }
            }

            if (count != ans[i]) {
                return false;
            }
        }

        return true;
    }
}