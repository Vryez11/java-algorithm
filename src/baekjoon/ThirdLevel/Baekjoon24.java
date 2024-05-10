package src.baekjoon.ThirdLevel;

import java.util.Scanner;

public class Baekjoon24 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalSum = scanner.nextInt();
        int amount = scanner.nextInt();
        int tempSum = 0;

        for (int i = 0; i < amount; i++) {
            int tempOrder = scanner.nextInt();
            int tempOrders = scanner.nextInt();

            tempSum += tempOrder * tempOrders;
        }

        if (totalSum == tempSum) System.out.println("Yes");
        else System.out.println("No");
    }
}
