package src.programmers.lv2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem4 {

    //올바른 괄호
    boolean solution(String s) {
        char[] sArr = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : sArr) {
            stack.push(c);
        }

        int clzCount = 0;

        while (!stack.isEmpty()) {
            if (stack.pop() == ')') {
                clzCount++;
            } else {
                if (clzCount > 0) clzCount --;
                else return false;
            }
        }

        if (clzCount == 0) return true;
        else return false;
    }
}
