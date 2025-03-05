package src.baekjoon.doit.combination;

import java.util.Arrays;
import java.util.Scanner;

public class Problem78 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            int k = input.nextInt();
            int n = input.nextInt();

            int[][] D = new int[k + 1][n + 1];
            int[][] S = new int[k + 1][n + 1];
            for (int j = 0; j <= k; j++) {
                D[j][1] = 1;
                S[j][1] = 1;
            }
            for (int j = 2; j <= n; j++) {
                D[0][j] = j;
                S[0][j] = S[0][j - 1] + D[0][j];
            }

            for (int j = 1; j <= k; j++) {
                for (int q = 2; q <= n; q++) {
                    D[j][q] = S[j-1][q];
                    S[j][q] = S[j][q - 1] + D[j][q];
                }
            }

            System.out.println(D[k][n]);
        }
    }
}
