package src.programmers.lv1;

import java.util.*;

public class Problem23 {

    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (stack.empty())
                stack.push(arr[i]);
            else {
                if (stack.peek() != arr[i])
                    stack.push(arr[i]);
            }
        }

        int capacity = stack.size();
        int[] result = new int[capacity];

        for (int i = capacity - 1; i > -1; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
