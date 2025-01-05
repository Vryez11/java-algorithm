package src.programmers.lv1;

import java.util.Stack;

public class Problem28 {

    public int solution(int n) {
        Stack<Integer> myStack = new Stack<>();
        int count = 0;

        while (n / 3 != 0) {
            myStack.push(n % 3);
            count++;
            n /= 3;
        }
        myStack.push(n % 3);
        count++;

        int reversInt = 0;

        for (int i = 0; i < count; i++) {
            reversInt += Math.pow(3, i) * myStack.pop();
        }

        return reversInt;
    }
}
