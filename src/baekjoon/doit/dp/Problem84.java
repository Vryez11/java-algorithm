package src.baekjoon.doit.dp;

import java.util.Scanner;

public class Problem84 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int X = input.nextInt();

        int[] D = new int[X + 1];
        D[1] = 0;
        for (int i = 2; i <= X; i++) {
            D[i] = D[i - 1] + 1;
            if (i % 2 == 0) D[i] = Math.min(D[i], D[i / 2] + 1);
            if (i % 3 == 0) D[i] = Math.min(D[i], D[i / 3] + 1);
        }

        System.out.println(D[X]);
    }
}
