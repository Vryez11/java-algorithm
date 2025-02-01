package src.baekjoon.level.eleventh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon83 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        br.close();
        long count = (long) n * (n - 1) / 2;

        System.out.println(count);
        System.out.println(2);
    }
}
