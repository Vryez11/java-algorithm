package src.baekjoon.level.nineteenth;

import java.util.Scanner;

public class Baekjoon145 {

    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        hanoi(N, 1, 2, 3);

        System.out.println(count);
        System.out.println(sb);
    }

    public static void hanoi(int n, int from, int temp, int to) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            count++;
            return;
        }

        hanoi(n - 1, from, to, temp);
        sb.append(from).append(" ").append(to).append("\n");
        count++;
        hanoi(n - 1, temp, from, to);
    }
}
