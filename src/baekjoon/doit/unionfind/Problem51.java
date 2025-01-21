package src.baekjoon.doit.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Problem51 {

    private static int[] A;
    private static int[] goal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        goal = new int[M];
        for (int i = 1; i <= N; i++) {
            A[i] = i;
        }
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");

            for (int j = 0; j < N; j++ ) {
                if (j != i) {
                    if (Objects.equals(split[j], "1")) {
                        union(i + 1, j + 1);
                    }
                }
            }
        }
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            goal[i] = Integer.parseInt(split[i]);
        }
        br.close();

        if (M == 1) {
            System.out.println("YES");
            return;
        }
        for (int i = 1; i < M; i++) {
            int[] res = find(goal[i - 1], goal[i]);
            if (res[0] != res[1]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static void union(int a, int b) {
        if (a == A[a] && b == A[b]) {
            if (a < b)
                A[b] = a;
            else
                A[a] = b;
        }

        int node1 = A[a];
        int node2 = A[b];
        while (node1 != A[node1]) {
            node1 = A[node1];
        }
        while (node2 != A[node2]) {
            node2 = A[node2];
        }
        if (node1 < node2) {
            A[node1] = node2;
        } else {
            A[node2] = node1;
        }
    }
    private static int[] find(int a, int b) {
        if (a == A[a] && b == A[b]) {
            return new int[]{a, b};
        }

        int[] res = find(A[a], A[b]);
        A[a] = res[0];
        A[b] = res[1];
        return res;
    }
}
