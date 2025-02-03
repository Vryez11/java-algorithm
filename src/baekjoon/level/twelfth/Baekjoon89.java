package src.baekjoon.level.twelfth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon89 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        br.close();

        for (int x = -999; x < 1000; x++) {
            for (int y = -999; y < 1000; y++) {
                if (isSolution(a, b, c, x, y)) {
                    if (isSolution(d, e, f, x, y)) {
                        System.out.println(x + " " + y);
                        return;
                    }
                }
            }
        }
    }

    private static boolean isSolution(int a, int b, int c, int x, int y) {
        return a * x + b * y == c;
    }
}
