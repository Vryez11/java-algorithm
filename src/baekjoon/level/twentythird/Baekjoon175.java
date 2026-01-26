package src.baekjoon.level.twentythird;

import java.util.Scanner;

public class Baekjoon175 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int K = input.nextInt();

        int[] coins = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            coins[i] = input.nextInt();
        }
        int cnt = 0;

        for (int i = N; i > 0; i--) {
            while(K - coins[i] >= 0) {
                K -= coins[i];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
