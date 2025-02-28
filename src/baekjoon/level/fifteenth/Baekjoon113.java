package src.baekjoon.level.fifteenth;

import java.util.Scanner;

public class Baekjoon113 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        long A = input.nextLong();
        long B = input.nextLong();

        long gcd = gcd(A, B);

        System.out.println(A * B / gcd);
    }

    private static long gcd(long a, long b) {
        if (b % a == 0) return a;

        return gcd(b, a % b);
    }
}
