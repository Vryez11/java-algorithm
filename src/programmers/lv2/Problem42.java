package src.programmers.lv2;

import java.util.Arrays;
import java.util.Stack;

public class Problem42 {

    // 주식가격
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[prices.length];

        stack.push(0);

        for (int i = 1; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                Integer now = stack.pop();
                result[now] = i - now;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            Integer now = stack.pop();
            result[now] = prices.length - now - 1;
        }

        return result;
    }
}
