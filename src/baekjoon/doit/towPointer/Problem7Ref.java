package src.baekjoon.doit.towPointer;

import java.util.Arrays;
import java.util.Scanner;

public class Problem7Ref {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int count = 0;
        int startIndex = 0;
        int endIndex = N - 1;

        while (startIndex < endIndex) {
            if (arr[startIndex] + arr[endIndex] < M) {
                startIndex++;
            } else if (arr[startIndex] + arr[endIndex] > M) {
                endIndex--;
            } else {
                count++;
                startIndex++;
                endIndex--;
            }
        }

        System.out.println(count);
    }
}
