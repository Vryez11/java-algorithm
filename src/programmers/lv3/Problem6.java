package src.programmers.lv3;

public class Problem6 {

    // 등굣길
    public int solution(int m, int n, int[][] puddles) {

        int[][] dp = new int[n][m];
        boolean[][] water = new boolean[n][m];

        for (int[] puddle : puddles) {
            water[puddle[1] - 1][puddle[0] - 1] = true;
        }

        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (water[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }

                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }

                dp[i][j] %= 1_000_000_007;
            }
        }

        return dp[n - 1][m - 1];
    }
}