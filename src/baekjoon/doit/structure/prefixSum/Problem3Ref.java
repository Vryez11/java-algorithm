package src.baekjoon.doit.structure.prefixSum;

import java.util.Scanner;

public class Problem3Ref {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] S = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            S[i] = S[i - 1] + sc.nextLong();
        }

        for (int q = 0; q < M; q++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            System.out.println(S[j] - S[i - 1]);
        }
    }
}
