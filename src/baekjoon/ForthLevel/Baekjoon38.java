package src.baekjoon.ForthLevel;

import java.util.Scanner;

public class Baekjoon38 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrStudent = new int[30];

        for (int i = 0; i < arrStudent.length - 2; i++) {
            int indexStudent = scanner.nextInt() - 1;
            arrStudent[indexStudent]++;
        }

        for (int j = 0; j < arrStudent.length; j++) {
            if (arrStudent[j] != 1) System.out.println((j+1));
        }
    }
}
