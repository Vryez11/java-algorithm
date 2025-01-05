package src.baekjoon.prefixSum;

import java.util.Scanner;

public class Problem4Ref {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        long[][] S = new long[M + 1][M + 1];

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= M; j++) {
                S[i][j] = S[i - 1][j] + S[i][j - 1] - S[i - 1][j - 1] + sc.nextLong();
            }
        }

        for (int q = 0; q < N; q++) {
            int arrY1 = sc.nextInt();
            int arrX1 = sc.nextInt();
            int arrY2 = sc.nextInt();
            int arrX2 = sc.nextInt();

            long sum = S[arrY2][arrX2] - S[arrY2][arrX1 - 1] - S[arrY1 - 1][arrX2] + S[arrY1 - 1][arrX1 - 1];

            System.out.println(sum);
        }
    }
}
