package src.baekjoon.doit.bubbleSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem15 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        for (int j = N - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                swap(A, i, i + 1);
            }
        }

        for (int num : A) {
            System.out.println(num);
        }
        br.close();
    }

    private static void swap(int[] A, int i, int j) {
        if (A[i] > A[j]) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
}
