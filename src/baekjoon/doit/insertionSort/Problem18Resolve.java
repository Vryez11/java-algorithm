package src.baekjoon.doit.insertionSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem18Resolve {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] S = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        insertionSort(A);

        S[0] = A[0];
        int sum = S[0];
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + A[i];
            sum += S[i];
        }

        System.out.println(sum);

        br.close();
    }

    private static void insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int tempIndex = i;
            int temp = A[i];
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] < A[i]) {
                    tempIndex = j + 1;
                    break;
                }
                if (j == 0)
                    tempIndex = 0;
            }
            for (int k = i; k > tempIndex; k--) {
                A[k] = A[k - 1];
            }
            A[tempIndex] = temp;
        }
    }
}
