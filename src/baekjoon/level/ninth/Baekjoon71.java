package src.baekjoon.level.ninth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon71 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int[] dias = new int[10_000_001];
        for (int i = 2; i < dias.length; i++) {
            dias[i] = i;
        }
        for (int i = 2; i < Math.sqrt(10_000_000); i++) {
            if (dias[i] == i) {
                int count = 2;
                while (i * count <= dias.length - 1) {
                    if (dias[i * count] != - 1)
                        dias[i * count] = -1;
                    count++;
                }
            }
        }
        int org = N;
        while (N >= 2) {
            for (int i = 2; i <= org; i++) {
                if (dias[i] == i && N % dias[i] == 0) {
                    System.out.println(dias[i]);
                    N /= dias[i];
                    break;
                }
            }
        }
    }
}
