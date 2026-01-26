package src.baekjoon.level.twentythird;

import java.util.Scanner;

public class Baekjoon179 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        long[] fee = new long[N - 1];
        long[] distance = new long[N];

        for (int i = 0; i < N - 1; i++) {
            distance[i] = input.nextLong();
        }
        for (int i = 0; i < N - 1; i++) {
            fee[i] = input.nextLong();
        }
        input.nextInt();

        long sum = 0;
        long curFee = fee[0];
        sum += curFee * distance[0];
        for (int i = 1; i < N - 1; i++) {
            if (curFee > fee[i]) {
                curFee = fee[i];
            }

            sum += curFee * distance[i];
        }
        System.out.println(sum);
    }
}
