package src.baekjoon.level.second;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Baekjoon43 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int hour = input.nextInt();
        int minute = input.nextInt();
        int durationMinutes = input.nextInt();

        LocalTime time = LocalTime.of(hour, minute, 0);
        Duration duration = Duration.of(durationMinutes, ChronoUnit.MINUTES);

        LocalTime plusTime = time.plus(duration);
        System.out.println(plusTime.getHour() + " " + plusTime.getMinute());
    }
}
