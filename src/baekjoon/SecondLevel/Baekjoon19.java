package src.baekjoon.SecondLevel;

import java.util.Scanner;

public class Baekjoon19 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = scanner.nextInt();
        int min = scanner.nextInt();
        int temphour = 0;

        int tempMin = scanner.nextInt();
        int finHour = tempMin / 60;
        int finMin = tempMin % 60;

        int resultMin = (min + finMin) > 59 ? min + finMin - 60 + temphour++ : min + finMin;
        int resultHour = (hour + finHour + temphour) > 23 ? hour + finHour + temphour - 24  : hour + finHour + temphour;

        System.out.println(resultHour + " " + resultMin);
    }
}
