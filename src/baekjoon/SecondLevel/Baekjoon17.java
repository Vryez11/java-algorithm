package src.baekjoon.SecondLevel;

import java.util.Scanner;

public class Baekjoon17 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int X = scanner.nextInt();
        int Y = scanner.nextInt();

        if (X * Y > 0) {
            if (X > 0) System.out.println(1);
            else System.out.println(3);
        } else {
            if (X > 0) System.out.println(4);
            else System.out.println(2);
        }
    }
}
