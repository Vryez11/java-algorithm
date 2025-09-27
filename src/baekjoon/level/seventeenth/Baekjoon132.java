package src.baekjoon.level.seventeenth;

import java.util.Scanner;

public class Baekjoon132 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        long res = 1L;

        for (int i = 0; i < N; i++) {
            res *= 2;
        }

        System.out.println(res);
    }
}
