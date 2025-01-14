package src.baekjoon.level.forth;

import java.util.Scanner;

public class Baekjoon35 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxInt = 0;
        int maxIndex = 0;
        int tempInt = 0;

        for (int i = 1; i <= 9; i++) {
            tempInt = scanner.nextInt();
            maxIndex = maxInt < tempInt ? i : maxIndex;
            maxInt = maxInt < tempInt ? tempInt : maxInt;
        }

        System.out.println(maxInt);
        System.out.println(maxIndex);
    }
}
