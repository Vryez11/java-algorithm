package src.baekjoon.level.sixteenth;

import java.util.Scanner;
import java.util.Stack;

public class Baekjoon122 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int T = input.nextInt();

        for (int i = 0; i < T; i++) {
            Stack<Character> myStack = new Stack<>();
            String vps = input.next();
            char[] chars = vps.toCharArray();
            boolean flag = false;

            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '(') {
                    myStack.push(chars[j]);
                } else {
                    if (!myStack.isEmpty() && myStack.peek() == '(')
                        myStack.pop();
                    else
                        break;
                }

                if (j == chars.length - 1 && myStack.isEmpty())
                    flag = true;
            }

            if (flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
