package src.baekjoon.level.twentyfirst;

import java.util.Scanner;

public class Baekjoon155 {

    static int[] dp = new int[1000001];
    static final int MOD = 15746;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
        }

        System.out.println(dp[N]);
    }
}
