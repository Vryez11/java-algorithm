package src.baekjoon.doit.structure.prefixSum;

import java.util.Scanner;

public class Problem3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int[] arrSum = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (i != 0) arrSum[i] = arr[i] + arrSum[i-1];
            else arrSum[i] = arr[i];
        }

        for (int i = 0; i < M; i++) {
            int n = Math.max(sc.nextInt() - 1, 0);
            int m = sc.nextInt() - 1;
            int sum = n == 0? arrSum[m] : arrSum[m] - arrSum[n - 1];

            System.out.println(sum);
        }
    }
}
