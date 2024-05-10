package src.baekjoon.ThirdLevel;

import java.util.Scanner;

public class Baekjoon25 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        String result = "int";

        for (int i = 0; i < num/4; i++) {
            System.out.print("long ");
        }

        System.out.println(result);
    }
}
