package src.programmers.lv2;

import java.util.Stack;

public class Problem45 {

    // 택배상자
    public int solution(int[] order) {

        Stack<Integer> stack = new Stack<>();
        int[] container = new int[order.length];
        for (int i = 1; i <= order.length; i++) {
            container[i - 1] = i;
        }
        int i = 0, j = 0;

        while (i < order.length) {
            if (container[i] != order[j]) {
                stack.push(container[i]);
                i++;
            } else {
                j++;
                i++;
                while (!stack.isEmpty() && stack.peek() == order[j]) {
                    stack.pop();
                    j++;
                }
            }
        }

        return order.length - stack.size();
    }
}
