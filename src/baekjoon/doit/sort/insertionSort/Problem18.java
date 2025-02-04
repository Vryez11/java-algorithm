package src.baekjoon.doit.sort.insertionSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem18 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int tempIndex = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (i == 1 && A[j] > A[i]) {
                    tempIndex = j;
                    continue;
                } else if (i == 1 && A[j] < A[i]) {
                    tempIndex = i;
                    continue;
                }
                if (A[j] > A[i]) {
                    tempIndex = j;
                    break;
                } else if (A[j] < A[i] && !(j + 1 == i)) {
                    continue;
                } else {
                    tempIndex = i;
                }
            }
            shift(A, tempIndex, i);
        }

        int[] S = new int[N + 1];
        int sum = 0;
        for (int i = 1; i < N + 1; i++) {
            S[i] = S[i - 1] + A[i - 1];
            sum += S[i];
        }

        System.out.println(sum);
    }
    private static void shift(int[] A, int tempIndex, int endIndex) {
        int temp = A[endIndex];
        for (int i = endIndex - 1; i > tempIndex - 1; i--) {
            A[i + 1] = A[i];
        }
        A[tempIndex] = temp;
    }
}
