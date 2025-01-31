package src.programmers.lv2;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem30 {

    //프로세스
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2) * -1);
        Queue<Node> q = new ArrayDeque<>();
        int count = 0;

        for (int i = 0; i < priorities.length; i++) {
            q.add(new Node(i, priorities[i]));
            pq.add(priorities[i]);
        }

        while (!q.isEmpty()) {
            Node now = q.poll();
            if (!pq.isEmpty() && pq.peek() == now.priority) {
                pq.poll();
                count++;
                if (now.node == location) return count;
            } else {
                q.add(now);
            }
        }

        return count;
    }

    private class Node {
        int node;
        int priority;

        public Node(int node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }
}
