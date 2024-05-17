package src.baekjoon.ForthLevel;

import java.util.Scanner;

public class Baekjoon37 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();

        int[] arr = new int[M];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        int N = scanner.nextInt();

        for(int i = 0; i < N; i++) {
            int startInt = scanner.nextInt() - 1;
            int endInt = scanner.nextInt() - 1;
            int tmp;

            tmp = arr[startInt];
            arr[startInt] = arr[endInt];
            arr[endInt] = tmp;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
