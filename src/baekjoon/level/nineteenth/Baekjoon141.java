package src.baekjoon.level.nineteenth;

import java.util.Scanner;

public class Baekjoon141 {

    static int count;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 0; i < T; i++) {
            count = 1;
            String str = input.next();

            System.out.println(isPalindrome(str) + " " + count);
        }
    }

    public static int recursion(String s, int l, int r) {
        if (l >= r) return 1;
        else if (s.charAt(l) != s.charAt(r)) return 0;
        else {
            count++;
            return recursion(s, l + 1, r - 1);
        }
    }

    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }
}
