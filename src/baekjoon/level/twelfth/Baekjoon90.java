package src.baekjoon.level.twelfth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon90 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int minChangeSum = Integer.MAX_VALUE;

        String[] lines = new String[M];
        for (int i = 0; i < M; i++) {
            lines[i] = br.readLine();
        }
        br.close();

        for (int i = 0; i <= M - 8; i++) {
            for (int j = 0; j <= N - 8; j++) {
                for (int q = 0; q < 2; q++) {
                    int changeSum = 0;
                    char startColor;
                    if (q == 0) startColor = 'W';
                    else startColor = 'B';

                    for (int k = 0; k < 8; k++) {
                        String tiles = lines[i + k].substring(j, j + 8);
                        changeSum += changeTile(tiles, startColor, k);
                    }
                    minChangeSum = Math.min(minChangeSum, changeSum);
                }
            }
        }
        System.out.println(minChangeSum);
    }

    private static int changeTile(String tiles, char startColor, int line) {
        char[] chars = tiles.toCharArray();
        int changeCount = 0;
        if (line % 2 == 0) {
            for (char tile : chars) {
                if (tile != startColor) changeCount++;

                if (startColor == 'W') startColor = 'B';
                else startColor = 'W';
            }
        } else {
            if (startColor == 'W') startColor = 'B';
            else startColor = 'W';

            for (char tile : chars) {
                if (tile != startColor) changeCount++;

                if (startColor == 'W') startColor = 'B';
                else startColor = 'W';
            }
        }
        return changeCount;
    }
}
