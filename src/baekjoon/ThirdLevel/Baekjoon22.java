package src.baekjoon.ThirdLevel;

import java.util.Scanner;

public class Baekjoon22 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int forNum = scanner.nextInt();

        for (int i = 0; i < forNum; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            System.out.println(a+b);
        }
    }
}
