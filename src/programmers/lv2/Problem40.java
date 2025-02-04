package src.programmers.lv2;

import java.util.Stack;

public class Problem40 {

    // 뒤에 있는 큰 수 찾기
    public int[] solution(int[] numbers) {
        int[] result = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        for (int i = 1; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                result[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }
}
