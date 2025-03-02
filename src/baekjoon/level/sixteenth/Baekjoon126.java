package src.baekjoon.level.sixteenth;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon126 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        Queue<Integer> cards = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            cards.offer(i);
        }

        while (cards.size() != 1) {
            cards.poll();
            cards.offer(cards.poll());
        }

        System.out.println(cards.poll());
    }
}
