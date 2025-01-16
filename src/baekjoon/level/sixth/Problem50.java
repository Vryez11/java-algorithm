package src.baekjoon.level.sixth;

import java.io.*;

public class Problem50 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++){
            for (int j = N- i; j > 0; j--) {
                sb.append(" ");
            }
            for (int k = 1; k <= (2 * (i - 1) + 1); k++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        for (int i = N - 1; i >= 1; i--) {
            for (int j = N - i; j > 0; j--) {
                sb.append(" ");
            }
            for (int k = 1; k <= (2 * (i - 1) + 1); k++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
