package src.baekjoon.level.twentyfirst;

import java.util.Scanner;

public class Baekjoon174 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int K = input.nextInt();

        int[][] bucket = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            bucket[i][0] = input.nextInt();
            bucket[i][1] = input.nextInt();
        }

        int[] dp = new int[K + 1];

        for (int i = 1; i <= N; i++) {
            int weight = bucket[i][0];
            int value = bucket[i][1];

            for (int w = K; w >= weight; w--) {
                dp[w] = Math.max(dp[w], dp[w - weight] + value);
            }
        }

        System.out.println(dp[K]);
    }
}
