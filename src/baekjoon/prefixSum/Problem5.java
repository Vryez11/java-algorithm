package src.baekjoon.prefixSum;

import java.util.Scanner;

public class Problem5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        long count = 0;

        long[] arrSum = new long[N + 1];
        int[] reminder = new int[M];

        for (int i = 1; i <= N; i++) {
            arrSum[i] = arrSum[i - 1] + sc.nextLong();
            if (arrSum[i] % M == 0) count++;
            reminder[(int) (arrSum[i] % M)]++;
        }

        for (long num : reminder) {
            if (num > 1) count += (num * (num - 1) / 2);
        }

        System.out.println(count);
    }
}
