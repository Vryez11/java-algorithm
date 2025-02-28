package src.baekjoon.level.fifteenth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baekjoon118 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        int[] primes = new int[1_000_001];
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i < primes.length; i++) {
            primes[i] = i;
        }
        for (int i = 2; i < Math.sqrt(primes.length); i++) {
            if (primes[i] == i) {
                for (int j = i * 2; j < primes.length; j = j + i) {
                    primes[j] = 0;
                }
            }
        }
        for (int i = 2; i < primes.length; i++) {
            if (primes[i] == i) {
                primeList.add(i);
            }
        }

        for (int i = 0; i < T; i++) {
            int N = input.nextInt();
            int count = 0;
            int index = 0;

            while (primeList.get(index) < N) {
                int other = N - primeList.get(index);
                if (primeList.get(index) <= other && primes[other] != 0) count++;

                index++;
            }

            System.out.println(count);
        }
    }
}
