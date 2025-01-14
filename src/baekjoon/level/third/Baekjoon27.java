package src.baekjoon.level.third;

import java.util.Scanner;

public class Baekjoon27 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int forNUm = scanner.nextInt();

        for (int i = 1; i <= forNUm; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println("Case #" + i + ": " + (a+b));
        }
    }
}
