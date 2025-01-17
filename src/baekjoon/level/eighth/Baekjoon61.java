package src.baekjoon.level.eighth;

import java.io.*;

public class Baekjoon61 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] coins = {25, 10, 5, 1};

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] coinCount = new int[4];

            for (int j = 0; j < coins.length; j++) {
                coinCount[j] = N / coins[j];
                N = N % coins[j];
            }
            for (int count : coinCount) {
                System.out.print(count + " ");
            }
            System.out.println();
        }
        br.close();
    }
}
