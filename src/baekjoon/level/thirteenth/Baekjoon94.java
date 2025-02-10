package src.baekjoon.level.thirteenth;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon94 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[5];
        int avg = 0;

        for (int i = 0; i < 5; i++) {
            arr[i] = input.nextInt();
            avg += arr[i];
        }

        Arrays.sort(arr);
        System.out.println(avg / 5);
        System.out.println(arr[2]);
    }
}
