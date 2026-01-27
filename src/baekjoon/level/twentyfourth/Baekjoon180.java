package src.baekjoon.level.twentyfourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon180 {

    private static int whiteCnt = 0;
    private static int blueCnt = 0;
    private static int[][] maps;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        maps = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        check(1, 1, N, N);

        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    private static void check(int startX, int startY, int endX, int endY) {

        if (startX == endX && startY == endY) {
            if (maps[startY][startX] == 0) whiteCnt++;
            else blueCnt++;

            return;
        }

        int tempColor = 0;
        for (int i = startY; i <= endY; i++) {
            for (int j = startX; j <= endX; j++) {
                if (i == startY && j == startX) {
                    tempColor = maps[i][j];
                    continue;
                }

                if (tempColor != maps[i][j]) {
                    divide(startX, startY, endX, endY);
                    return;
                }
            }
        }

        if (tempColor == 0) whiteCnt++;
        else blueCnt++;
    }

    private static void divide(int startX, int startY, int endX, int endY) {
        int midX = (startX + endX) / 2;
        int midY = (startY + endY) / 2;


        check(startX, startY, midX, midY);
        check(midX + 1, startY, endX, midY);
        check(startX, midY + 1, midX, endY);
        check(midX + 1, midY + 1, endX, endY);
    }
}
