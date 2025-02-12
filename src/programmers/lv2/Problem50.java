package src.programmers.lv2;

public class Problem50 {

    // 2 x n 타일링
    public int solution (int n) {

        final int MOD = 1_000_000_007;

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        return dp[n];
    }
}
