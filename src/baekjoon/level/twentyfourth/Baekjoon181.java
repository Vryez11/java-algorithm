package src.baekjoon.level.twentyfourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon181 {

    private static int[][] maps;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        maps = new int[N][N];
        String nums;
        for (int i = 0; i < N; i++) {
            nums = br.readLine();
            char[] charArr = nums.toCharArray();
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(String.valueOf(charArr[j]));
            }
        }

        check(0, 0, N - 1, N - 1);

        System.out.println(sb.toString());
    }

    private static void check(int startX, int startY, int endX, int endY) {

        if (startX == endX && startY == endY) {
            if (maps[startY][startX] == 0) sb.append(0);
            else sb.append(1);

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

        if (tempColor == 0) sb.append(0);
        else sb.append(1);
    }

    private static void divide(int startX, int startY, int endX, int endY) {
        int midX = (startX + endX) / 2;
        int midY = (startY + endY) / 2;

        sb.append("(");
        check(startX, startY, midX, midY);
        check(midX + 1, startY, endX, midY);
        check(startX, midY + 1, midX, endY);
        check(midX + 1, midY + 1, endX, endY);
        sb.append(")");
    }
}
