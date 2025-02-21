package src.baekjoon.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem5 {

    // RGB 거리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                int index1, index2;
                if (j == 0) {
                    index1 = 1;
                    index2 = 2;
                } else if (j == 1) {
                    index1 = 0;
                    index2 = 2;
                } else {
                    index1 = 0;
                    index2 = 1;
                }

                arr[i][j] = arr[i][j] + Math.min(arr[i - 1][index1], arr[i - 1][index2]);
            }
        }

        System.out.println(Math.min(arr[N][0], Math.min(arr[N][1], arr[N][2])));
    }
}
