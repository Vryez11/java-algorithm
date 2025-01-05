package src.baekjoon.bufferedPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekP4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        System.out.println(N * (M % 10));
        System.out.println(N * (M / 10 % 10));
        System.out.println(N * (M / 100));
        System.out.println(N * M);

        br.close();
    }
}
