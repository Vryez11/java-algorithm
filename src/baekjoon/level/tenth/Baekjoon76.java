package src.baekjoon.level.tenth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon76 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] vertex = new int[4];
        vertex[0] = Integer.MAX_VALUE;
        vertex[1] = Integer.MIN_VALUE;
        vertex[2] = Integer.MAX_VALUE;
        vertex[3] = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tempX = Integer.parseInt(st.nextToken());
            int tempY = Integer.parseInt(st.nextToken());
            vertex[0] = Math.min(vertex[0], tempX);
            vertex[1] = Math.max(vertex[1], tempX);
            vertex[2] = Math.min(vertex[2], tempY);
            vertex[3] = Math.max(vertex[3], tempY);
        }
        br.close();

        System.out.println((vertex[1] - vertex[0]) * (vertex[3] - vertex[2]));
    }
}
