package src.baekjoon.level.twelfth;

import java.util.Scanner;

public class Baekjoon91 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int count = 0;
        Long num = 666L;
        while (count < N) {
            String str = String.valueOf(num);
            if (str.contains("666")) {
                count++;
            }
            num++;
        }

        System.out.println(num - 1);
    }
}
