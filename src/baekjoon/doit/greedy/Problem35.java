package src.baekjoon.doit.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem35 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt((Node o) -> o.endTime).thenComparingInt(o -> o.startTime));
        int meetingCount = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        br.close();

        Node currentNode = pq.poll();
        meetingCount++;

        while (!pq.isEmpty()) {
            if (currentNode.endTime <= pq.peek().startTime) {
                currentNode = pq.poll();
                meetingCount++;
            } else {
                pq.poll();
            }
        }

        System.out.println(meetingCount);
    }

    private static class Node {
        private final int startTime;
        private final int endTime;

        public Node(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }
    }
}
