package src.baekjoon.doit.dp;

import java.util.*;

public class Problem87 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        if (n == 1) {
            System.out.println(1);
            return;
        }

        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10_007;
        }
        System.out.println(dp[n]);
    }
}