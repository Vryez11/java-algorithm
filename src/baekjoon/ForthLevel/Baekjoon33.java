package src.baekjoon.ForthLevel;

import java.util.Scanner;

public class Baekjoon33 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrIndex = scanner.nextInt();
        int tempX = scanner.nextInt();

        for (int i = 0; i < arrIndex; i++) {
            int tempA = scanner.nextInt();
            if (tempX > tempA) System.out.print(tempA + " ");
        }
    }
}
