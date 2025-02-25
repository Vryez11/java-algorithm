package src.programmers.lv2;

import java.util.Stack;

public class Problem59 {

    // 큰 수 만들기
    public String solution(String number, int k) {

        Stack<Character> stack = new Stack<>();
        int length = number.length();

        for (int i = 0; i < length; i++) {
            char c = number.charAt(i);

            while (!stack.isEmpty() && k > 0 && stack.peek() < c) {
                stack.pop();
                k--;
            }

            stack.push(c);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
