package src.programmers.lv3;

public class Problem26 {

    // 거스름돈
    public int solution(int n, int[] money) {
        final int MOD = 1_000_000_007;

        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int coin : money) {
            for (int price = coin; price <= n; price++) {
                dp[price] = (dp[price] + dp[price - coin]) % MOD;
            }
        }

        return dp[n];
    }
}