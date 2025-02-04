package src.baekjoon.doit.number.euclideen;

import java.util.Scanner;

public class Problem43 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long A = input.nextLong();
        long B = input.nextLong();

        int gcd = gcd(A, B);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gcd; i++) {
            sb.append(1);
        }
        System.out.println(sb);
    }

    private static int gcd(long a, long b) {
        if (b == 0) return (int) a;
        else return gcd(b, a % b);
    }
}
