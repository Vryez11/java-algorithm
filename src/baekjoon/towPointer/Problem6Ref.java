package src.baekjoon.towPointer;

import java.util.Scanner;

public class Problem6Ref {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 1;
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;

        while (endIndex < N) {
            if (sum == N) {
                endIndex++;
                sum += endIndex;
                count++;
            } else if (sum < N) {
                endIndex++;
                sum += endIndex;
            } else {
                sum -= startIndex;
                startIndex++;
            }
        }

        System.out.println(count);
    }
}
