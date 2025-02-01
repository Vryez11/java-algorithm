package src.baekjoon.level.eleventh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon85 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        br.close();

        // 조합 nC3 계산: n(n-1)(n-2) / 6
        long count = (n * (n - 1) * (n - 2)) / 6;

        System.out.println(count);
        System.out.println(3); // 최고차항의 차수
    }
}
