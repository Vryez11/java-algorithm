package src.baekjoon.doit.graphSection.unionfind;

import java.util.Scanner;

public class Problem50Ref {

    private static int[] parent;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            int question = input.nextInt();
            int a = input.nextInt();
            int b = input.nextInt();

            if (question == 0) {
                union(a, b);
            } else {
                if (checkSum(a, b))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }
    private static int find(int x) {
        if (x == parent[x])
            return x;
        else
            return parent[x] = find(parent[x]);
    }
    private static boolean checkSum(int a, int b) {
        a = find(a);
        b = find(b);
        return a == b;
    }
}
