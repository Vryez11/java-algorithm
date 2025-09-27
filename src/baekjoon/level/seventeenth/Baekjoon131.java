package src.baekjoon.level.seventeenth;

import java.util.Scanner;

public class Baekjoon131 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        if (N == 1) {
            System.out.println(0);
            return;
        }

        System.out.println(N * (N - 1));
    }
}
