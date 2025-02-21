package src.baekjoon.sw;

import java.util.*;

public class Problem1 {

    // 1463번 1로 만들기

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        boolean[] visited = new boolean[N + 1];
        Queue<Node> q = new ArrayDeque<>();

        visited[N] = true;
        q.offer(new Node(N, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.value == 1) {
                System.out.println(now.depth);
                break;
            }

            if (now.value % 2 == 0 && !visited[now.value / 2]) {
                q.offer(new Node(now.value / 2, now.depth + 1));
            }
            if (now.value % 3 == 0 && !visited[now.value / 3]) {
                q.offer(new Node(now.value / 3, now.depth + 1));
            }
            if (!visited[now.value - 1]) {
                q.offer(new Node(now.value - 1, now.depth + 1));
            }
        }
    }

    static class Node {
        int value;
        int depth;

        public Node(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }
}
