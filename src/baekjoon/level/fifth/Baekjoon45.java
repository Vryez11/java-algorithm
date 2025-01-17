package src.baekjoon.level.fifth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon45 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String s = br.readLine();
        char[] sArray = s.toCharArray();
        br.close();

        int sum = 0;

        for (char c : sArray) {
            sum += Integer.parseInt(String.valueOf(c));
        }

        System.out.println(sum);
    }
}
