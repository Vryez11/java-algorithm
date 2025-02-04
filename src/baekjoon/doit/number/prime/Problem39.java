package src.baekjoon.doit.number.prime;

import java.util.Scanner;

public class Problem39 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int N = input.nextInt();
        int[] A = new int[1000000 + 1];
        
        for (int i = 2; i <= A.length - 1; i++) {
            A[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(A.length - 1); i++) {
            if (A[i] == 0) continue;
            
            for (int j = i + i; j <= A.length - 1; j = j + i) {
                A[j] = 0;
            }
        }

        for (int i = N; i <= A.length - 1; i++) {
            if (A[i] != 0) {
                if (isPalindrome(i)) {
                    System.out.println(i);
                    return;
                }
            }
        }
        System.out.println(1003001);
    }

    private static boolean isPalindrome(int num) {
        String number = String.valueOf(num);
        int start = 0, end = number.length() - 1;
        while (start < end) {
            if (number.charAt(start) != number.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
