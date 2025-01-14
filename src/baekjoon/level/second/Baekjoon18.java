package src.baekjoon.level.second;

import java.util.Scanner;

public class Baekjoon18 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = scanner.nextInt();
        int min = scanner.nextInt();

        if ((min - 45) < 0){
            min += 15;
            if ((hour - 1) < 0) {
                hour += 23;
            } else {
                hour -= 1;
            }
        } else {
            min -= 45;
        }

        System.out.println(hour + " " + min);
    }
}
