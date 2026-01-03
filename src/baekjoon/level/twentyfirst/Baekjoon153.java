package src.baekjoon.level.twentyfirst;

import java.util.Scanner;

public class Baekjoon153 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 1 || n == 2) {
            System.out.println(1 + " " + 1);
        }

        int[] fib = new int[n + 1];

        fib[1] = 1;
        fib[2] = 1;

        for(int i = 3; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        System.out.println(fib[n] + " " + (n - 2));
    }
}
