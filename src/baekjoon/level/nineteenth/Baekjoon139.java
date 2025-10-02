package src.baekjoon.level.nineteenth;

import java.util.Scanner;

public class Baekjoon139 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        if (N == 0) {
            System.out.println(1);
            return;
        }

        System.out.println(fact(N));
    }

    public static long fact(int n) {
        if (n == 1) return 1L;

        return n * fact(n - 1);
    }
}
