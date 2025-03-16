package src.baekjoon.doit.combination;

import java.util.Scanner;

public class Problem83 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        long mod = 1_000_000_000;
        long[] D = new long[1_000_001];
        D[1] = 0;
        D[2] = 1;
        for (int i = 3; i <= N; i++) {
            D[i] = (i - 1) * (D[i - 1] + D[i - 2]) % mod;
        }
        System.out.println(D[N]);
    }
}
