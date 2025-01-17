package src.baekjoon.level.eighth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon60 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        br. close();

        StringBuilder sb = new StringBuilder();

        while (N / B != 0) {
            sb.append(changeChar(N % B));
            N /= B;
        }
        sb.append(changeChar(N)).reverse();

        System.out.println(sb);
    }

    private static char changeChar (int num) {
        if (0 <= num && num <= 9) {
            return (char) (num + '0');
        }
        if (10 <= num && num <= 35) {
            return (char) (num + 'A' - 10);
        }
        else
            return '-';
    }
}
