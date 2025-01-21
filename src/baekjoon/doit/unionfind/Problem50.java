package src.baekjoon.doit.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem50 {

    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        A = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            A[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int menu = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (menu == 0) {
                union(a, b);
            } else {
                int[] result = find(a, b);
                if (result[0] == result[1]) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        br.close();
    }

    private static void union(int a, int b) {
        if (A[a] == a && A[b] == b) {
            if (a < b) A[b] = a;
            else A[a] = b;
            return;
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
            A[node2] = node1;
        } else {
            A[node1] = node2;
        }
    }

    private static int[] find(int a, int b) {
        if (A[a] == a && A[b] == b) {
            return new int[]{a, b};
        }

        int[] res = find(A[a], A[b]);
        A[a] = res[0];
        A[b] = res[1];

        return new int[]{res[0], res[1]};
    }
}
