package src.baekjoon.arraylist;

import java.util.Scanner;

public class Problem1Ref {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String sNum = sc.next();

        int sum = 0;

        char[] charArray = sNum.toCharArray();

        for (char c : charArray) {
            sum += Integer.parseInt(String.valueOf(c));
        }

        System.out.println(sum);
    }
}
