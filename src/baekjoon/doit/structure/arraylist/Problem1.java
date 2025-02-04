package src.baekjoon.doit.structure.arraylist;

import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long T = sc.nextLong();
        int sum = 0;

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = (int) (T % 10);
            T /= 10;
        }
        for (int i : arr) {
            sum += i;
        }
        System.out.println(sum);
    }
}
