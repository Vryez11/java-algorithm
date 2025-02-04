package src.baekjoon.doit.structure.slidingWindow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Problem10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        Deque<Node> mydeque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int now = sc.nextInt();

            while (!mydeque.isEmpty() && mydeque.getLast().value > now) {
                mydeque.removeLast();
            }
            mydeque.addLast(new Node(now, i));

            if (mydeque.getFirst().index <= i - L) {
                mydeque.removeFirst();
            }
            System.out.println(mydeque.getFirst().value + " ");
        }
    }

    static class Node {
        private int value;
        private int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
