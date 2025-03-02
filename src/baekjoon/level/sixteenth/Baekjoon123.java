package src.baekjoon.level.sixteenth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon123 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line.equals(".")) break;

            Stack<Character> myStack = new Stack<>();
            boolean flag = false;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                if ('A' <= c && c <= 'Z') continue;
                if ('a' <= c && c <= 'z') continue;
                if ('0' <= c && c <= '9' || c == ' ') continue;

                if (c == '(' || c == '[') {
                    myStack.push(c);
                }
                if (c == ')') {
                    if (!myStack.isEmpty() && myStack.peek() == '(') {
                        myStack.pop();
                    }
                    else break;
                }
                if (c == ']') {
                    if (!myStack.isEmpty() && myStack.peek() == '[') {
                        myStack.pop();
                    }
                    else break;
                }

                if (i == line.length() - 1 && myStack.isEmpty())
                    flag = true;
            }
            br.close();

            if (flag) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
