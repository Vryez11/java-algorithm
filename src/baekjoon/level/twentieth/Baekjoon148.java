package src.baekjoon.level.twentieth;

import java.util.Scanner;

public class Baekjoon148 {

    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static void dfs(int depth, int before) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (i >= before) {
                arr[depth] = i;
                dfs(depth + 1, i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N + 1];

        dfs(0, 0);

        System.out.print(sb.toString());
    }
}
