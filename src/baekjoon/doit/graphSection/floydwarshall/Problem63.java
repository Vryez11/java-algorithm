package src.baekjoon.doit.graphSection.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem63 {

    private static final int INF = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    A[i][j] = 0;
                } else {
                    A[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S - 1][E - 1] = 1;
            A[E - 1][S - 1] = 1;
        }
        br.close();

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (A[i][k] != INF && A[k][j] != INF) {
                        if (A[i][j] > A[i][k] + A[k][j]) {
                            A[i][j] = A[i][k] + A[k][j];
                        }
                    }
                }
            }
        }
        int minKevinValue = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < N; i++) {
            if (minKevinValue > Arrays.stream(A[i]).sum()) {
                minKevinValue = Arrays.stream(A[i]).sum();
                minIndex = i + 1;
            };
        }
        System.out.println(minIndex);
    }
}
