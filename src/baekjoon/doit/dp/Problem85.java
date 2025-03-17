package src.baekjoon.doit.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem85 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] counsels = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            counsels[i][0] = Integer.parseInt(st.nextToken());
            counsels[i][1] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            int nextDay = i + counsels[i][0];
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            if (nextDay <= N) {
                dp[nextDay] = Math.max(dp[nextDay], dp[i] + counsels[i][1]);
            }
        }

        System.out.println(dp[N]);
    }
}