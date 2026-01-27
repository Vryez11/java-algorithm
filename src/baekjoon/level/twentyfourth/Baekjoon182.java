package src.baekjoon.level.twentyfourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon182 {

    private static int[][] paper;
    private static int minusOne = 0;
    private static int zero = 0;
    private static int one = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check(0, 0, N);

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }

    private static void check(int x, int y, int size) {
        if (isSame(x, y, size)) {
            int v = paper[y][x];
            if (v == -1) minusOne++;
            else if (v == 0) zero++;
            else one++;
            return;
        }

        int next = size / 3;

        for (int dy = 0; dy < 3; dy++) {
            for (int dx = 0; dx < 3; dx++) {
                check(x + dx * next, y + dy * next, next);
            }
        }
    }

    private static boolean isSame(int x, int y, int size) {
        int value = paper[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (paper[i][j] != value) return false;
            }
        }
        return true;
    }
}
