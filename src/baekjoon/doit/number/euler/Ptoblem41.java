package src.baekjoon.doit.number.euler;

import java.util.Scanner;

public class Ptoblem41 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long n = input.nextLong();
        long result = n;

        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                result = result - result / i;
            }
            while (n % i ==0) {
                n /= i;
            }
        }
        if (n > 1) {
            result = result - result / n;
        }

        System.out.println(result);
    }
}
