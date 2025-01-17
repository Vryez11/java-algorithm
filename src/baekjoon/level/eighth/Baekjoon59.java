package src.baekjoon.level.eighth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon59 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        String N = input[0]; // B진법 숫자
        int B = Integer.parseInt(input[1]); // 진법
        br.close();

        long res = 0;
        int length = N.length();

        for (int i = 0; i < length; i++) {
            char c = N.charAt(i);
            int value = changeNum(c);

            res = res * B + value;
        }

        System.out.println(res);
    }

    private static int changeNum(char c) {
        if ('0' <= c && c <= '9') {
            return c - '0';
        } else if ('A' <= c && c <= 'Z') {
            return c - 'A' + 10;
        } else {
            return -1;
        }
    }
}
