package src.baekjoon.level.eighth;

import java.util.Scanner;

public class Baekjoon64 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int X = input.nextInt();
        int sum = 0;
        int count = 1;

        while (sum < X) {
            sum += count;
            count++;
        }
        int start, end;

        if ((count - 1) % 2 == 0) {
            start = 1;
            end = count - 1;
            for (int i = sum - (count - 2); i < X; i++) {
                start++;
                end--;
            }
        } else {
            start = count - 1;
            end = 1;
            for (int i = sum - (count - 2); i < X; i++) {
                start--;
                end++;
            }
        }
        System.out.println(start + "/" + end);
    }
}
