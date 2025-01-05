package src.baekjoon.level.ThirdLevel;

import java.util.Scanner;

public class Baekjoon28 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int forNUm = scanner.nextInt();

        for (int i = 1; i <= forNUm; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println("Case #" + i + ": " + a + " + " + b + " = " + (a+b));
        }
    }
}
