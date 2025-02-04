package src.baekjoon.doit.structure.towPointer;

import java.util.Arrays;
import java.util.Scanner;

public class Problem8Ref {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            long sum = arr[i];
            int startIndex = 0;
            int endIndex = N - 1;

            while (startIndex < endIndex) {
                if (arr[startIndex] + arr[endIndex] == sum) {
                    if (startIndex != i && endIndex != i) {
                        count++;
                        break;
                    } else if (startIndex == i) {
                        startIndex++;
                    } else {
                        endIndex--;
                    }
                } else if (arr[startIndex] + arr[endIndex] < sum) {
                    startIndex++;
                } else {
                    endIndex--;
                }
            }
        }

        System.out.println(count);
    }
}
