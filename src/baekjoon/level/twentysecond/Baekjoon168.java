package src.baekjoon.level.twentysecond;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon168 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] ps = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                char cur = line.charAt(j - 1);
                char expected = ((i + j) % 2 == 0) ? 'W' : 'B';
                int diff = (cur == expected) ? 0 : 1;

                ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + diff;
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= N - K + 1; i++) {
            for (int j = 1; j <= M - K + 1; j++) {
                int x2 = i + K - 1;
                int y2 = j + K - 1;

                int w = ps[x2][y2] - ps[i - 1][y2] - ps[x2][j - 1] + ps[i - 1][j - 1];

                int b = K * K - w;
                ans = Math.min(ans, Math.min(w, b));
            }
        }

        System.out.println(ans);
        br.close();
    }
}