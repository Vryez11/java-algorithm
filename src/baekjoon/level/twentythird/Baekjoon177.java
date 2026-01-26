package src.baekjoon.level.twentythird;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon177 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = input.nextInt();
        }

        Arrays.sort(arr);
        int sum = 0;

        int[] S = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            S[i] = S[i - 1] + arr[i];
            sum += S[i];
        }

        System.out.println(sum);
    }
}
