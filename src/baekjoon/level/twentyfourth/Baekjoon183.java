package src.baekjoon.level.twentyfourth;

import java.util.Scanner;

public class Baekjoon183 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        long A = input.nextLong();
        long B = input.nextLong();
        long C = input.nextLong();

        System.out.println(powMod(A, B, C));
    }

    private static long powMod(long a, long b, long mod) {
        if (b == 0) return 1 % mod;
        if (b == 1) return a % mod;

        long half = powMod(a, b / 2, mod);
        long result = (half * half) % mod;

        if (b % 2 == 1) {
            result = (result * (a % mod)) % mod;
        }
        return result;
    }
}
