package src.baekjoon.level.twentyfirst;

import java.util.Scanner;

public class Baekjoon161 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if (N == 1) {
            System.out.println(0);
            return;
        }

        long[] dp = new long[N + 1];
        for (int i = 2; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[1] = 0;

        for(int i = 1; i < N; i++) {
            if ((i + 1) > N) continue;
            dp[i + 1] = Math.min(dp[i] + 1, dp[i + 1]);

            if ((i * 2) > N) continue;
            dp[i * 2] = Math.min(dp[i] + 1, dp[i * 2]);

            if ((i * 3) > N) continue;
            dp[i * 3] = Math.min(dp[i] + 1, dp[i * 3]);
        }

        System.out.println(dp[N]);
    }
}
