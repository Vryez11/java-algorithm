package src.baekjoon.level.twentieth;

import java.util.Scanner;

public class Baekjoon146 {

    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        
        arr = new int[M];

        dfs(0, 1);

        System.out.print(sb.toString());
    }
}
