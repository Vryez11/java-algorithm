package src.baekjoon.level.sixteenth;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon121 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int K = input.nextInt();

        Stack<Integer> myStack = new Stack<>();
        int sum = 0;

        for (int i = 0; i < K; i++) {
            int num = input.nextInt();

            if (num == 0) {
                sum -= myStack.pop();
            } else {
                myStack.push(num);
                sum += num;
            }
        }

        System.out.println(sum);
    }
}
