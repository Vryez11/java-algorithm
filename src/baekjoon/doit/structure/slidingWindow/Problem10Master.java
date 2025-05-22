package src.baekjoon.doit.structure.slidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Problem10Master {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int L = input.nextInt();

        Deque<Node> dq = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (!dq.isEmpty()) {
               if (dq.peekFirst().index <= i - L)  {
                   dq.removeFirst();
               }
            }
            Node now = new Node(input.nextInt(), i);

            while (!dq.isEmpty() && dq.peekLast().value >= now.value) {
                dq.removeLast();
            }
            dq.addLast(now);

            System.out.print(dq.peekFirst().value + " ");
        }
    }

    static class Node {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
