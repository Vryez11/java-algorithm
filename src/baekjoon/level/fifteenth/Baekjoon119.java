package src.baekjoon.level.fifteenth;

import java.util.Scanner;

public class Baekjoon119 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long N = input.nextLong();
        input.close();

        long result = (long) Math.sqrt(N);

        System.out.println(result);
    }
}
