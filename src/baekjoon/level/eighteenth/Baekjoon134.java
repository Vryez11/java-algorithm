package src.baekjoon.level.eighteenth;

import java.util.Scanner;

public class Baekjoon134 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int tmp = input.nextInt();

            if (min > tmp) min = tmp;
            if (max < tmp) max = tmp;
        }

        System.out.println(min * max);
    }
}
