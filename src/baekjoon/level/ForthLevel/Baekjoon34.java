package src.baekjoon.level.ForthLevel;

import java.util.Scanner;

public class Baekjoon34 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrIndex = scanner.nextInt();
        int maxInt = scanner.nextInt();
        int minInt = maxInt;

        for (int i = 0; i <arrIndex-1; i++) {
            int tempA = scanner.nextInt();

            maxInt = tempA > maxInt ? tempA : maxInt;
            minInt = tempA < minInt ? tempA : minInt;
        }

        System.out.print(minInt + " " + maxInt);
    }
}