package src.baekjoon.level.twentyfirst;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon172 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        int[][] wires = new int[N][2];
        for (int i = 0; i < N; i++) {
            wires[i][0] = input.nextInt();
            wires[i][1] = input.nextInt();
        }

        Arrays.sort(wires, (a, b) -> Integer.compare(a[0], b[0]));

        int[] dp = new int[N];
        int lis = 0;

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (wires[j][1] < wires[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            lis = Math.max(lis, dp[i]);
        }

        System.out.println(N - lis);
    }
}
