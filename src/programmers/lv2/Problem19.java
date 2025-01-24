package src.programmers.lv2;

import java.util.Stack;

public class Problem19 {

    //괄호 회전하기
    public int solution(String s) {
        char[] chars = new char[s.length() + 1];
        int count = 0;
        for (int i = 1; i <=  s.length(); i++) {
            chars[i] = s.charAt(i - 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (check(chars)) {
                count++;
            }
            shiftChars(chars);
        }

        return count;
    }

    private boolean check(char[] chars) {
        Stack<Character> stack = new Stack<>();

        for (int i = 1; i < chars.length; i++) {
            char bracket = chars[i];
            if (!stack.isEmpty() && stack.peek() == bracket) {
                stack.pop();
            } else {
                stack.push(changeBracket(bracket));
            }
        }
        return stack.isEmpty();
    }
    private void shiftChars(char[] chars) {
        for (int i = 1; i < chars.length; i++) {
            chars[i - 1] = chars[i];
        }
        chars[chars.length - 1] = chars[0];
    }
    private char changeBracket(char c) {
        switch(c) {
            case '(':
                return ')';
            case '{':
                return '}';
            case '[':
                return ']';
            default:
                return c;
        }
    }
}
