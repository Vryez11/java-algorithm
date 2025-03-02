package src.baekjoon.level.sixteenth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon124 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        Stack<Integer> myStack = new Stack<>();
        Queue<Integer> myQueue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            myQueue.add(Integer.parseInt(st.nextToken()));
        }

        int nCount = 1;

        while (nCount <= N) {
            while (!myQueue.isEmpty() && myQueue.peek() == nCount) {
                myQueue.poll();
                nCount++;
            }

            while (!myStack.isEmpty() && myStack.peek() == nCount) {
                myStack.pop();
                nCount++;
            }

            while (!myQueue.isEmpty() && myQueue.peek() != nCount) {
                myStack.add(myQueue.poll());
            }

            if (myQueue.isEmpty() && !myStack.isEmpty() && myStack.peek() != nCount) {
                System.out.println("Sad");
                return;
            }
        }
        System.out.println("Nice");
    }
}
