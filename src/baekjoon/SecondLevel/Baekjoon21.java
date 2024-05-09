package src.baekjoon.SecondLevel;

import java.util.Scanner;

public class Baekjoon21 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstAmount = scanner.nextInt();
        int secondAmount = scanner.nextInt();
        int thirdAmount = scanner.nextInt();
        int sameAmount = 0;
        int diceCase = 0;

        if (firstAmount == secondAmount) {
            diceCase++;
            sameAmount = firstAmount;
        }
        if (firstAmount == thirdAmount) {
            diceCase++;
            sameAmount = thirdAmount;
        }
        if (secondAmount == thirdAmount) {
            diceCase++;
            sameAmount = secondAmount;
        }

        int MaxAmount = (firstAmount >= secondAmount) ? firstAmount : secondAmount;
        int LastMaxAmount = (MaxAmount >= thirdAmount) ? MaxAmount : thirdAmount;

        switch (diceCase) {
            case 3:
                System.out.println((10000 + sameAmount * 1000));
                break;
            case 1:
                System.out.println((1000 + sameAmount * 100));
                break;
            default:
                System.out.println(LastMaxAmount * 100);

        }
    }
}
