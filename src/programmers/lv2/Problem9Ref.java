package src.programmers.lv2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem9Ref {

    //짝지어 제거하기
    public int solution(String s) {
        char[] sArr = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : sArr) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
