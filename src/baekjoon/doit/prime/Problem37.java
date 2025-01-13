package src.baekjoon.doit.prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem37 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        br.close();

        boolean[] primes = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 2; j * 2 <= N; j++) {
                primes[j * 2] = true;
            }
            if (i < M) {
                primes[i] = true;
            } else {
                if (!primes[i]) {
                    if (isPrime(i)) {
                        System.out.println(i);
                        for (int j = 2; i * j <= N; j++) {
                            primes[i * j] = true;
                        }
                    }
                }
            }
        }
    }

    private static boolean isPrime(int n) {
        int count = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                count++;
            }
        }

        return count < 2;
    }
}
