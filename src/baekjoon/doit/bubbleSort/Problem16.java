package src.baekjoon.doit.bubbleSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem16 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
            B[i] = A[i];
        }

        Arrays.sort(A);

        int[] diff = new int[N];
        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex < N) {
            if (A[firstIndex] != B[secondIndex]) {
                secondIndex++;
            } else {
                if (secondIndex > firstIndex) {
                    diff[firstIndex] = secondIndex - firstIndex + 1;
                }
                secondIndex = 0;
                firstIndex++;
            }
        }

        int max = Arrays.stream(diff).max().getAsInt();
        System.out.println(max);

        br.close();
    }
}
