package src.programmers.lv3;

import java.util.Arrays;

public class Problem33 {

    // 합승 택시 요금
    public int solution(int n, int s, int a, int b, int[][] fares) {

        final int INF = 20_000_000;

        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int[] fare : fares) {
            int c = fare[0];
            int d = fare[1];
            int f = fare[2];

            dist[c][d] = f;
            dist[d][c] = f;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int answer = INF;

        for (int i = 1; i <= n; i++) {
            int cost = dist[s][i] + dist[i][a] + dist[i][b];
            answer = Math.min(answer, cost);
        }

        return answer;
    }
}