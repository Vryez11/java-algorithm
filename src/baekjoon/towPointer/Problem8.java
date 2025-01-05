package src.baekjoon.towPointer;

import java.util.Arrays;
import java.util.Scanner;

public class Problem8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);
        int count = 0;

        for (int i = 0; i < N; i++) {
            long sum = arr[i];
            int startIndex = 0;
            int endIndex = N - 1;

            while (startIndex < endIndex) {
                if (startIndex == i) {
                    startIndex++;
                    continue;
                } else if (endIndex == i) {
                    endIndex--;
                    continue;
                }

                if (arr[startIndex] + arr[endIndex] < sum) {
                    startIndex++;
                } else if (arr[startIndex] + arr[endIndex] > sum) {
                    endIndex--;
                } else {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
