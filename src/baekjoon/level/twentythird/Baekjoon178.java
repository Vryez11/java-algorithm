package src.baekjoon.level.twentythird;

import java.util.Scanner;

public class Baekjoon178 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String line = input.nextLine();
        String[] plusWords = line.split("-");

        int res = 0;

        for (int i = 0; i < plusWords.length; i++) {
            String[] numbers = plusWords[i].split("\\+");
            int tempSum = 0;

            for (String number : numbers) {
                int realNum = Integer.parseInt(number);
                tempSum += realNum;
            }

            if (i == 0) {
                res += tempSum;
                continue;
            }

            res -= tempSum;
        }

        System.out.println(res);
    }
}
