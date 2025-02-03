package src.baekjoon.level.twelfth;

import java.util.Scanner;

public class Baekjoon88 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        int num = 1;
        while (num < N) {
            if ((jarisuSum(num) + num) == N) break;
            num++;
        }
        if (num == N) System.out.println(0);
        else System.out.println(num);
    }

    private static int jarisuSum(int num) {
        int sum = 0;
        while (num / 10 != 0) {
            sum += num % 10;
            num /= 10;
        }
        sum += num;
        return sum;
    }
}
