package src.baekjoon.level.forth;

import java.util.Scanner;

public class Baekjoon32 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrNum = scanner.nextInt();
        int[] arrInt = new int[arrNum];

        for (int i = 0; i < arrNum; i++) {
            arrInt[i] = scanner.nextInt();
        }

        int tempv = scanner.nextInt();
        int count = 0;

        for (int i : arrInt) {
            if (i == tempv) count++;
        }

        System.out.println(count);
    }
}
