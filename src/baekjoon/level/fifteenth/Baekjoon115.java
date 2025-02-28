package src.baekjoon.level.fifteenth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon115 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] tree = new int[N];
        int[] dist = new int[N - 1];
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(br.readLine());

            if (i > 0) {
                dist[i- 1] = tree[i] - tree[i-1];
            }
        }
        br.close();

        int gcd = gcd(dist[0], dist[1]);
        for (int i = 2; i < N - 1; i++) {
            gcd = gcd(gcd, dist[i]);
        }

        int treeCount = 0;
        for (int i = 0; i < N - 1; i++) {
            treeCount += (dist[i] / gcd) - 1;
        }

        System.out.println(treeCount);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }
}