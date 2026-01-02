package src.baekjoon.level.twentieth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon149 {

    static int N;
    static int count;
    static boolean[] colUsed;
    static boolean[] diag1Used;
    static boolean[] diag2Used;
    static void dfs(int row) {

        if (row == N) {
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            int d1 = row + col;
            int d2 = row - col + (N - 1);

            if (colUsed[col] || diag1Used[d1] || diag2Used[d2]) continue;

            colUsed[col] = true;
            diag1Used[d1] = true;
            diag2Used[d2] = true;

            dfs(row + 1);

            colUsed[col] = false;
            diag1Used[d1] = false;
            diag2Used[d2] = false;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        count = 0;

        colUsed = new boolean[N];
        diag1Used = new boolean[2 * N - 1];
        diag2Used = new boolean[2 * N - 1];

        dfs(0);

        System.out.println(count);
    }
}
