package src.baekjoon.doit.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem91 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][] dp = new long[n][m];

        long max = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                dp[i][j] = str.charAt(j) - '0';
                if (dp[i][j] == 1) {
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        br.close();

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.println(max * max);
    }
}