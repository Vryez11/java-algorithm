package src.baekjoon.doit.prime;

import java.util.Scanner;

public class Problem38 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        int[] primes = new int[10_000_000 + 1];

        for (int i = 2; i < primes.length; i++) {
            primes[i] = i;
        }

        for (int i = 2; i < Math.sqrt(primes.length); i++) {
            if (primes[i] == 0) continue;

            for (int j = i + i; j < primes.length; j = j + i) {
                primes[j] = 0;
            }
        }
        int count = 0;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i] != 0) {
                long temp = primes[i];
                while ((double) primes[i] <= (double)B / (double)temp) {
                    if ((double) primes[i] >= (double)A  / (double)temp) {
                        count++;
                    }
                    temp = temp * primes[i];
                }
            }
        }
        System.out.println(count);
    }
}
