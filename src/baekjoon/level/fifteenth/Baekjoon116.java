package src.baekjoon.level.fifteenth;

import java.util.Scanner;

public class Baekjoon116 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 0; i < T; i++) {
            long n = input.nextLong();

            while (true) {
                if (isPrime(n)) {
                    System.out.println(n);
                    break;
                }

                n++;
            }
        }
    }

    private static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
