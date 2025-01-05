package src.baekjoon.doit.towPointer;

import java.util.Scanner;

public class Problem6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;
        int whileCount = 1;

        while(whileCount <= N) {
            int sum = 0;
            for (int i = whileCount; i <= N; i++) {
                sum += i;
                if (sum == N) {
                    count++;
                    break;
                } else if (sum > N) {
                    break;
                }
            }
            whileCount++;
        }

        System.out.println(count);
    }
}
