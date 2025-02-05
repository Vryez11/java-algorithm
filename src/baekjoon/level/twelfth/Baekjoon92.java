package src.baekjoon.level.twelfth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon92 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        br.close();

        if (N % 5 == 0) {
            count = N / 5;
            System.out.println(count);
            return;
        }
        count = N / 5 + 1;

        while (count > 0) {
            count--;
            if ((N - count * 5) % 3 == 0) {
                count += (N - count * 5) / 3;
                System.out.println(count);
                return;
            }
        }
        System.out.println(-1);
    }
}
