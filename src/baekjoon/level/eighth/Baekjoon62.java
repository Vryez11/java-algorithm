package src.baekjoon.level.eighth;

import java.util.Scanner;

public class Baekjoon62 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] S = new int[N + 1];
        S[0] = 2;

        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                S[i] = 3;
                continue;
            }
            S[i] = S[i - 1] + S[i - 1] - 1;
        }
        System.out.println(S[N] * S[N]);
    }
}
