package src.baekjoon.level.twentieth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon152 {

    static int N;
    static int min = Integer.MAX_VALUE;
    static int[][] stats;
    static boolean[] pick;
    static void dfs(int idx, int cnt) {

        if (cnt == N / 2) {
            min = Math.min(min, calDiff());
            return;
        }

        if (idx == N) return;

        if (cnt + (N - idx) < N / 2) return;

        pick[idx] = true;
        dfs(idx + 1, cnt + 1);

        pick[idx] = false;
        lo
        dfs(idx + 1, cnt);
    }

    static int calDiff() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (pick[i] && pick[j]) {
                    start += (stats[i][j] + stats[j][i]);
                } else if (!pick[i] && !pick[j]) {
                    link += (stats[i][j] + stats[j][i]);
                }
            }
        }

        return Math.abs(start - link);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        stats = new int[N][N];
        pick = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pick[0] = true;
        dfs(1, 1);

        System.out.println(min);
    }
}
