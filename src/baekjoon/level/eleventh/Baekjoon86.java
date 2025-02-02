package src.baekjoon.level.eleventh;

import java.util.Scanner;

public class Baekjoon86 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a1 = input.nextInt();
        int a0 = input.nextInt();
        int c = input.nextInt();
        int n0 = input.nextInt();

        if (a1 > c) System.out.println(0);
        else {
            int minF = a1 * n0 + a0;
            int minG = n0 * c;

            if (minG >= minF) System.out.println(1);
            else System.out.println(0);
        }
    }
}