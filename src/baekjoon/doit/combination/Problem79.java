package src.baekjoon.doit.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem79 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] D = new int[M + 1][M + 1];
            for (int j = 0; j <= M; j++) {
                D[j][1] = j;
                D[j][0] = 1;
                D[j][j] = 1;
            }

            for (int j = 2; j <= M; j++) {
                for (int k = 1; k < j; k++) {
                    D[j][k] = D[j - 1][k - 1] + D[j - 1][k];
                }
            }

            System.out.println(D[M][N]);
        }
        br.close();
    }
}
