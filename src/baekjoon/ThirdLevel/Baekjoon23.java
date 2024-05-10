package src.baekjoon.ThirdLevel;

import java.util.Scanner;

public class Baekjoon23 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int amount = scanner.nextInt();
        int sum = 0;

        while(amount > 0) {
            sum += amount;
            amount--;
        }
        System.out.println(sum);
    }
}
