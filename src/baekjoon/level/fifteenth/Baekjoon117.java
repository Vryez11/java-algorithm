package src.baekjoon.level.fifteenth;

import java.util.Scanner;

public class Baekjoon117 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while(true) {
            int n = input.nextInt();
            if (n == 0) break;

            int count = 0;

            for (int j = n + 1; j <= 2 * n; j++) {
                if (isPrime(j)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
