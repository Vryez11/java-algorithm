package src.baekjoon.level.twentyfirst;

import java.util.Scanner;

public class Baekjoon156 {

    static long[] dp = new long[101];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        int cnt = 1;

        for (int j = 6; j <= 100; j++) {
            dp[j] = dp[j - 1] + dp[cnt++];
        }

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            System.out.println(dp[N]);
        }
    }
}
