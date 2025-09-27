package src.baekjoon.level.seventeenth;

import java.util.Scanner;

public class Baekjoon133 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        if (N == 0) {
            System.out.println(1);
            return;
        }

        System.out.println(fact(N));
    }

    static int fact(int n) {
        if (n == 1) return 1;

        return n * fact(n - 1);
    }
}
