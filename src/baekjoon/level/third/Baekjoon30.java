package src.baekjoon.level.third;

import java.util.Scanner;

public class Baekjoon30 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int forNum = scanner.nextInt();

        for (int i = 1; i <= forNum; i++) {
            for (int k = 0; k < forNum - i; k++){
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
