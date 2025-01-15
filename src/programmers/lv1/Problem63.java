package src.programmers.lv1;

import java.util.Stack;

public class Problem63 {

    public int solution(int[] ingredients) {
        Stack<Integer> stack = new Stack<>();
        int[] recipe = {1, 2, 3, 1};
        int count = 0; int order = 0;

        for (int ingredient : ingredients) {
            stack.push(ingredient);
            if (ingredient == recipe[order]) {
                order++;
            } else {
                order = 0;
                if (ingredient == recipe[order]) {
                    order++;
                }
            }

            if (order == 4) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop();
                order = 0;
                count++;
                if (!stack.isEmpty() && stack.peek() == recipe[order]) order++;
                else if (!stack.isEmpty() && stack.peek() == recipe[order + 1]) {
                    int temp = stack.pop();
                    if (!stack.isEmpty() && stack.peek() == recipe[order]) order = 2;
                    stack.push(temp);
                }
            }
        }

        return count;
    }
}
