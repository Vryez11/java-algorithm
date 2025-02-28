package src.baekjoon.level.fifteenth;

import java.util.Scanner;

public class Baekjoon112 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 0; i < T; i++) {
            int A = input.nextInt();
            int B = input.nextInt();

            int gcd = gcd(A, B);

            System.out.println(A * B / gcd);
        }
    }

    private static int gcd(int a, int b) {
        if (b % a == 0) return a;

        return gcd(b, a % b);
    }
}
