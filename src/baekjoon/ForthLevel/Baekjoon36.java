package src.baekjoon.ForthLevel;

import java.util.Scanner;

public class Baekjoon36 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();

        int[] arr = new int[M];

        int N = scanner.nextInt();

        for(int i = 0; i < N; i++) {
            int startInt = scanner.nextInt() - 1;
            int endInt = scanner.nextInt() - 1;
            int num = scanner.nextInt();

            for (int j = startInt; j <= endInt; j++) {
                arr[j] = num;
            }
        }

        for(int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
    }
}
