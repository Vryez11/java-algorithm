package src.baekjoon.doit.combination;

import java.util.Scanner;

public class Problem80 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int M = input.nextInt();

        int[] NBox = new int[M];
        int N = 0;

        for (int i = 0; i < M; i++) {
            NBox[i] = input.nextInt();
            N += NBox[i];
        }

        int K = input.nextInt();

        if (K == 1 || M == 1) {
            System.out.println(1.0);
            return;
        }

        double probability = 0.0;

        for (int num : NBox) {
            if (num >= K) {
                probability += combination(num, K) / combination(N, K);
            }
        }

        System.out.println(probability);
    }

    public static double combination(int n, int k) {
        if (k > n) return 0;
        double result = 1.0;

        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }

        return result;
    }
}
